/*
 * Copyright (c) 2015 [1076559197@qq.com | tchen0707@gmail.com]
 *
 * Licensed under the Apache License, Version 2.0 (the "License”);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dream.library.widgets.imageblur;

import android.graphics.Bitmap;

/**
 * https://github.com/qiujuer/ImageBlurring
 * Android 中通过 Java 与 JNI 分别进行图片模糊；并且进行比较其运算速度。
 */
public class ImageBlur {

  static {
    System.loadLibrary("ImageBlur");
  }

  public static native void blurIntArray(int[] pixelArray, int width, int height, int radius);

  public static native void blurBitMap(Bitmap bitmap, int radius);
}
