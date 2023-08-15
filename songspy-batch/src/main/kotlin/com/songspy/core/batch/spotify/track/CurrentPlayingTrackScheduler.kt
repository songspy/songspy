package com.songspy.core.batch.spotify.track

import com.songspy.clients.spotify.SpotifyClient
import com.songspy.core.batch.spotify.token.SpotifyTokenReader
import com.songspy.core.batch.spotify.token.TokenBucket
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class CurrentPlayingTrackScheduler(
    private val spotifyClient: SpotifyClient,
    private val spotifyTokenReader: SpotifyTokenReader,
    private val spotifyCurrentPlayingTrackMapper: SpotifyCurrentPlayingTrackMapper,
    private val spotifyCurrentPlayingTrackAppender: SpotifyCurrentPlayingTrackAppender,
    private val spotifyCurrentPlayingTrackReader: SpotifyCurrentPlayingTrackReader
) {
    private val logger = LoggerFactory.getLogger(javaClass)

    @Async
    @Scheduled(fixedDelay = CURRENTLY_PLAYING_TRACK__SCHEDULE_TIME)
    fun schedule() {
        logger.info("spotify currently playing track scheduler start")
        val tokens = spotifyTokenReader.readUnExpired()
        tokens.forEach {
            getAndAppendPlayingTrack(it)
        }
    }

    private fun getAndAppendPlayingTrack(tokenBucket: TokenBucket) {
        val trackDto = spotifyClient.getCurrentlyPlayingTrack(tokenBucket.accessToken)
            .onFailure { println(it) }
            .getOrNull()
        if (trackDto != null) {
            val currentPlayingTrack = spotifyCurrentPlayingTrackMapper.map(trackDto.item)
            if (canAppend(tokenBucket.userId, currentPlayingTrack.id)) {
                spotifyCurrentPlayingTrackAppender.append(tokenBucket.userId, currentPlayingTrack)
                logger.info("[current track append success] user: ${tokenBucket.userId} | track: $currentPlayingTrack")
            }
        }
    }

    private fun canAppend(userId: Long, trackId: String): Boolean {
        return spotifyCurrentPlayingTrackReader.readByUserIdAndTrackId(userId, trackId) == null
    }

    companion object {
        private const val CURRENTLY_PLAYING_TRACK__SCHEDULE_TIME = 1_000L * 30 // 30초
    }
}
