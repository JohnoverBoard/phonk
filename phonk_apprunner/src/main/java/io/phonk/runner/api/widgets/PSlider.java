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

package io.phonk.runner.api.widgets;

import android.view.MotionEvent;

import io.phonk.runner.api.common.ReturnInterface;
import io.phonk.runner.api.common.ReturnObject;
import io.phonk.runner.apprunner.AppRunner;
import io.phonk.runner.apprunner.StyleProperties;
import io.phonk.runner.base.utils.MLog;
import io.phonk.runner.base.views.CanvasUtils;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by biquillo on 11/09/16.
 */
public class PSlider extends PCanvas implements PViewMethodsInterface {

    private static final String TAG = PSlider.class.getSimpleName();

    public StyleProperties props = new StyleProperties();
    public Styler styler;

    private ArrayList touches;
    private float x;
    private float y;
    private boolean touching;
    private ReturnInterface callback;
    private int mWidth;
    private int mHeight;
    private float mappedVal;
    private float rangeFrom = 0;
    private float rangeTo = 1;

    public PSlider(AppRunner appRunner) {
        super(appRunner);
        MLog.d(TAG, "create slider");

        draw = mydraw;
        styler = new Styler(appRunner, this, props);
        styler.apply();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = event.getX();
        y = event.getY();

        if (x < 0) x = 0;
        if (x > mWidth) x = mWidth;
        if (y < 0) y = 0;
        if (y > mHeight) y = mHeight;

        mappedVal = CanvasUtils.map(x, 0, mWidth, rangeFrom, rangeTo);

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                return true;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                return false;
        }

        if (callback != null) {
            ReturnObject ret = new ReturnObject();
            ret.put("value", mappedVal);
            callback.event(ret);
        }

        invalidate();
        return true;
    }

    OnDrawCallback mydraw = new OnDrawCallback() {
        @Override
        public void event(PCanvas c) {
            mWidth = c.width;
            mHeight = c.height;

            c.clear();
            c.mode(true);

            if (!touching) c.fill(styler.slider);
            else c.fill(styler.sliderPressed);
            c.strokeWidth(styler.sliderBorderSize);
            c.stroke(styler.sliderBorderColor);
            c.rect(0, 0, x, c.height);
        }
    };

    public PSlider onChange(final ReturnInterface callbackfn) {
        this.callback = callbackfn;

        return this;
    }

    public PSlider range(float from, float to) {
        rangeFrom = from;
        rangeTo = to;

        return this;
    }
    
    @Override
    public void set(float x, float y, float w, float h) {
        styler.setLayoutProps(x, y, w, h);
    }

    @Override
    public void setStyle(Map style) {
        styler.setStyle(style);
    }

    @Override
    public Map getStyle() {
        return props;
    }

}
