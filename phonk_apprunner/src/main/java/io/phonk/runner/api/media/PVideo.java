/*
 * Part of Phonk http://www.phonk.io
 * A prototyping platform for Android devices
 *
 * Copyright (C) 2013 - 2017 Victor Diaz Barrales @victordiaz (Protocoder)
 * Copyright (C) 2017 - Victor Diaz Barrales @victordiaz (Phonk)
 *
 * Phonk is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Phonk is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Phonk. If not, see <http://www.gnu.org/licenses/>.
 *
 */

package io.phonk.runner.api.media;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;

import io.phonk.runner.apidoc.annotation.ProtoMethod;
import io.phonk.runner.apidoc.annotation.ProtoMethodParam;
import io.phonk.runner.apprunner.AppRunner;
import io.phonk.runner.base.gui.CustomVideoTextureView;
import io.phonk.runner.base.utils.MLog;

public class PVideo extends PAudioPlayer {

    private static final java.lang.String TAG = PVideo.class.getSimpleName();

    private final CustomVideoTextureView mTextureView;

    public PVideo(AppRunner appRunner) {
        super(appRunner);

        MLog.d(TAG, "trying to put surface");

        mTextureView = new CustomVideoTextureView(appRunner.getAppContext());
        mTextureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
        @Override
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int width, int height) {
            MLog.d(TAG, "surface available");
            mMediaPlayer.setSurface(new Surface(surfaceTexture));
        }

        @Override
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int width, int height) {

        }

        @Override
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {

        }
        });

        /*
        mTextureView.setListener(new CustomVideoTextureView.OnEvent() {
            @Override
            public void surfaceTextureAvailable(SurfaceTexture surfaceTexture) {
          }
        });

        */
    }

    /*
    public PVideo addVideoPlayer(float x, float y, float w, float h) {
        getAppRunner().pUi.add(mTextureView, x, y, w, h);

        return this;
    }
    */

    public View getPreview() {
        return mTextureView;
    }

    @ProtoMethod(description = "Gets the video width", example = "")
    @ProtoMethodParam(params = {""})
    public int getVideoWidth() {
        return mMediaPlayer.getVideoWidth();
    }

    @ProtoMethod(description = "Gets the video height", example = "")
    @ProtoMethodParam(params = {""})
    public int getVideoHeight() {
        return mMediaPlayer.getVideoHeight();
    }
}
