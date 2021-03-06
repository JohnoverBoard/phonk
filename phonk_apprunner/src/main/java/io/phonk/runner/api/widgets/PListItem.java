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

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import io.phonk.runner.apidoc.annotation.ProtoMethod;
import io.phonk.runner.apidoc.annotation.ProtoMethodParam;

import java.lang.ref.WeakReference;

public class PListItem extends LinearLayout {

    private final WeakReference<View> v;
    // private Context c;
    private final Context c;
    private String t;

    public PListItem(Context context) {
        super(context);
        this.c = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //TODO activate this
        this.v = null; //new WeakReference<View>(inflater.inflate(R.layout.view_project_item_, this, true));
    }

    //TODO place holder

    @ProtoMethod(description = "", example = "")
    @ProtoMethodParam(params = {""})
    public void setImage(int resId) {
        //TODO activate this
        ImageView imageView = null; //(ImageView) v.get().findViewById(R.id.customViewImage);
        imageView.setImageResource(resId);

        // drawText(imageView, mTouches);
    }

    //TODO place holder

    @ProtoMethod(description = "", example = "")
    @ProtoMethodParam(params = {""})
    public void setText(String text) {
        this.t = text;
        //TODO activate this
        TextView textView = null; //(TextView) v.get().findViewById(R.id.customViewText);
        // TextUtils.changeFont(c.get(), textView, ProtocoderFonts.MENU_TITLE);
        textView.setText(text);
    }

    //TODO place holder

    @ProtoMethod(description = "", example = "")
    @ProtoMethodParam(params = {""})
    public String getName() {
        return t;
    }

}
