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


import io.phonk.runner.api.common.ReturnInterface;
import io.phonk.runner.base.gui.CameraNew;

public interface PCameraInterface {

    void takePicture(String file, final ReturnInterface callbackfn);
    void recordVideo(String file);
    void stopRecordingVideo();
    void focus(ReturnInterface callback);
    void setPreviewSize(int w, int h);
    void setPictureResolution(int w, int h);
    boolean isFlashAvailable();
    void turnOnFlash(boolean b);
    void setColorEffect(String effect);
    void onNewBitmap(final CameraNew.CallbackBmp callbackfn);
    void onNewStreamFrame(CameraNew.CallbackStream callbackfn);

}
