/*
 * Copyright 2011 The Closure Compiler Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
<<<<<<< HEAD
 * @fileoverview Externs for YouTube Player API for <iframe> Embeds
=======
 * @fileoverview Externs for YouTube Player API for <iframe> Embeds.
>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
 * @see http://code.google.com/apis/youtube/iframe_api_reference.html
 * @externs
 */

<<<<<<< HEAD
/** @return {undefined} */
var onYouTubePlayerAPIReady = function() {};

/** @return {undefined} */
window.onYouTubePlayerAPIReady = function() {};

/** @const */
var YT = {};

=======

/** @return {undefined} */
var onYouTubePlayerAPIReady = function() {};


/** @return {undefined} */
window.onYouTubePlayerAPIReady = function() {};


/** @const */
var YT = {};



>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
/**
 * @constructor
 * @param {(string|Element)} container
 * @param {Object.<string, *>} opts
 */
YT.Player = function(container, opts) {};

<<<<<<< HEAD
=======

>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
/**
 * @param {string} videoId
 * @param {number=} startSeconds
 * @param {string=} suggestedQuality
 */
YT.Player.prototype.cueVideoById =
    function(videoId, startSeconds, suggestedQuality) {};

<<<<<<< HEAD
=======

>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
/**
 * @param {string} videoId
 * @param {number=} startSeconds
 * @param {string=} suggestedQuality
 */
YT.Player.prototype.loadVideoById =
    function(videoId, startSeconds, suggestedQuality) {};

<<<<<<< HEAD
=======

>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
/**
 * @param {string} mediaContentUrl
 * @param {number} startSeconds
 * @param {string=} suggestedQuality
 */
YT.Player.prototype.cueVideoByUrl =
    function(mediaContentUrl, startSeconds, suggestedQuality) {};

<<<<<<< HEAD
=======

>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
/**
 * @param {string} mediaContentUrl
 * @param {number} startSeconds
 * @param {string=} suggestedQuality
 */
YT.Player.prototype.loadVideoByUrl =
    function(mediaContentUrl, startSeconds, suggestedQuality) {};

<<<<<<< HEAD
=======

>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
/**
 * @param {(String|Array.<String>)} playlist
 * @param {number=} index
 * @param {number=} startSeconds
 * @param {string=} suggestedQuality
 */
YT.Player.prototype.cuePlaylist =
    function(playlist, index, startSeconds, suggestedQuality) {};

<<<<<<< HEAD
=======

>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
/**
 * @param {(String|Array.<String>)} playlist
 * @param {number=} index
 * @param {number=} startSeconds
 * @param {string=} suggestedQuality
 */
YT.Player.prototype.loadPlaylist =
    function(playlist, index, startSeconds, suggestedQuality) {};

<<<<<<< HEAD
/** @return {undefined} */
YT.Player.prototype.playVideo = function() {};

/** @return {undefined} */
YT.Player.prototype.pauseVideo = function() {};

/** @return {undefined} */
YT.Player.prototype.stopVideo = function() {};

=======

/** @return {undefined} */
YT.Player.prototype.playVideo = function() {};


/** @return {undefined} */
YT.Player.prototype.pauseVideo = function() {};


/** @return {undefined} */
YT.Player.prototype.stopVideo = function() {};


>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
/**
 * @param {number} seconds
 * @param {boolean} allowSeekAhead
 */
YT.Player.prototype.seekTo = function(seconds, allowSeekAhead) {};

<<<<<<< HEAD
/** @return {undefined} */
YT.Player.prototype.clearVideo = function() {};

/** @return {undefined} */
YT.Player.prototype.nextVideo = function() {};

/** @return {undefined} */
YT.Player.prototype.previousVideo = function() {};

/** @param {number} index */
YT.Player.prototype.playVideoAt = function(index) {};

/** @return {undefined} */
YT.Player.prototype.mute = function() {};

/** @return {undefined} */
YT.Player.prototype.unMute = function() {};

/** @return {boolean} */
YT.Player.prototype.isMuted = function() {};

/** @param {number} volume */
YT.Player.prototype.setVolume = function(volume) {};

=======

/** @return {undefined} */
YT.Player.prototype.clearVideo = function() {};


/** @return {undefined} */
YT.Player.prototype.nextVideo = function() {};


/** @return {undefined} */
YT.Player.prototype.previousVideo = function() {};


/** @param {number} index */
YT.Player.prototype.playVideoAt = function(index) {};


/** @return {undefined} */
YT.Player.prototype.mute = function() {};


/** @return {undefined} */
YT.Player.prototype.unMute = function() {};


/** @return {boolean} */
YT.Player.prototype.isMuted = function() {};


/** @param {number} volume */
YT.Player.prototype.setVolume = function(volume) {};


>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
/**
 * @return {number}
 * @nosideeffects
 */
YT.Player.prototype.getVolume = function() {};

<<<<<<< HEAD
/** @param {boolean} loopPlaylists */
YT.Player.prototype.setLoop = function(loopPlaylists) {};

/** @param {boolean} shufflePlaylist */
YT.Player.prototype.setShuffle = function(shufflePlaylist) {};

=======

/** @param {boolean} loopPlaylists */
YT.Player.prototype.setLoop = function(loopPlaylists) {};


/** @param {boolean} shufflePlaylist */
YT.Player.prototype.setShuffle = function(shufflePlaylist) {};


>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
/**
 * @return {number}
 * @nosideeffects
 */
YT.Player.prototype.getVideoBytesLoaded = function() {};

<<<<<<< HEAD
=======

>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
/**
 * @return {number}
 * @nosideeffects
 */
YT.Player.prototype.getVideoBytesTotal = function() {};

<<<<<<< HEAD
=======

>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
/**
 * @return {number}
 * @nosideeffects
 */
YT.Player.prototype.getVideoStartBytes = function() {};

<<<<<<< HEAD
=======

>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
/**
 * @return {YT.PlayerState|number}
 * @nosideeffects
 */
YT.Player.prototype.getPlayerState = function() {};

<<<<<<< HEAD
=======

>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
/**
 * @return {number}
 * @nosideeffects
 */
YT.Player.prototype.getCurrentTime = function() {};

<<<<<<< HEAD
=======

>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
/**
 * @return {(undefined|string)}
 * @nosideeffects
 */
YT.Player.prototype.getPlaybackQuality = function() {};

<<<<<<< HEAD
/** @param {string} suggestedQuality */
YT.Player.prototype.setPlaybackQuality = function(suggestedQuality) {};

=======

/** @param {string} suggestedQuality */
YT.Player.prototype.setPlaybackQuality = function(suggestedQuality) {};


>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
/**
 * @return {Array.<string>}
 * @nosideeffects
 */
YT.Player.prototype.getAvailableQualityLevels = function() {};

<<<<<<< HEAD
=======

>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
/**
 * @return {number}
 * @nosideeffects
 */
YT.Player.prototype.getDuration = function() {};

<<<<<<< HEAD
=======

>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
/**
 * @return {string}
 * @nosideeffects
 */
YT.Player.prototype.getVideoUrl = function() {};

<<<<<<< HEAD
=======

>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
/**
 * @return {string}
 * @nosideeffects
 */
YT.Player.prototype.getVideoEmbedCode = function() {};

<<<<<<< HEAD
=======

>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
/**
 * @return {Array.<string>}
 * @nosideeffects
 */
YT.Player.prototype.getPlaylist = function() {};

<<<<<<< HEAD
=======

>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
/**
 * @return {number}
 * @nosideeffects
 */
YT.Player.prototype.getPlaylistIndex = function() {};

<<<<<<< HEAD
=======

>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
/**
 * @param {string} eventName
 * @param {string} listenerName
 */
YT.Player.prototype.addEventListener = function(eventName, listenerName) {};

<<<<<<< HEAD
/** @enum */
YT.PlayerState = {
    ENDED: 0,
    PLAYING: 1,
    PAUSED: 2,
    BUFFERING: 3,
    CUED: 4
};

=======

/** Destroys the player reference. */
YT.Player.prototype.destroy = function() {};


/** @enum */
YT.PlayerState = {
  ENDED: 0,
  PLAYING: 1,
  PAUSED: 2,
  BUFFERING: 3,
  CUED: 4
};



>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
/**
 * @constructor
 * @private
 */
YT.Event = function() {};

<<<<<<< HEAD
/** @type {string|number|undefined} */
YT.Event.prototype.data;

=======

/** @type {string|number|undefined} */
YT.Event.prototype.data;


>>>>>>> 5c522db6e745151faa1d8dc310d145e94f78ac77
/** @type {YT.Player} */
YT.Event.prototype.target = null;
