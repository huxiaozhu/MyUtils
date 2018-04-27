package com.sgxxqp.test.utils;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;

import java.io.ByteArrayOutputStream;


/**
 * Created by liuxiaozhu on 2017/8/24.
 * All Rights Reserved by YiZu
 * 图片转换工具
 */
public class ImageUtils {
    /**
     * base64转为bitmap
     * @param base64Data
     * @return
     */
    public static Bitmap base64ToBitmap(String base64Data) {
        byte[] bytes = Base64.decode(base64Data, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }

    /**
     * Bitmap转换二进制
     * @param bitmap
     * @return
     */
    public static byte[] getBinary(Bitmap bitmap) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bos);
        return bos.toByteArray();
    }

    /**
     * bitmap转成Base64
     * @param bitmap
     * @return
     */
    public static String getBaseString(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] bytes = stream.toByteArray();
        String image = Base64.encodeToString(bytes, Base64.DEFAULT);
        return "data:image/png;base64," +image;
    }

    /**
     * **********************相机参考方法（）****************************
     */

//    /**
//     * 吊起相机
//     */
//    public void startCamer(int CAMERA) {
//        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        startActivityForResult(intent, CAMERA);
//    }
//
//    /**
//     * 吊起本地相册
//     */
//    public void startAlbum(int ALBUM) {
//        Intent pickIntent = new Intent(Intent.ACTION_PICK, null);
//        pickIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
//                "image/*");
//        startActivityForResult(pickIntent, ALBUM);
//    }
//
//    /**
//     * 获取图片的Base64
//     * @param data
//     * @return
//     */
//    public String getImgUrl(Intent data) {
//        String base64 = "";
//        Bundle extras = data.getExtras();
//        if (extras != null) {
//            Bitmap photo = extras.getParcelable("data");
//            //获取将图片转换成Drawable格式（暂时不用）
////            Drawable drawable = new BitmapDrawable(getResources(), photo);
//            /** 可用于图像上传 */
//            base64 = ImageUtils.getBaseString(photo);
//
//        }
//        return base64;
//    }
//
//    /**
//     * 裁剪图片
//     */
//    public void shearPic(Intent data, int SHEAR) {
//        if (data == null || data.getData() == null) {
//            return;
//        }
//        Intent intent = new Intent("com.android.camera.action.CROP");
//        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
//        intent.setDataAndType(data.getData(), "image/*");
//        intent.putExtra("crop", true);
//        intent.putExtra("aspectX", 1);
//        intent.putExtra("aspectY", 1);
//        intent.putExtra("outputX", 150);
//        intent.putExtra("outputY", 150);
//        intent.putExtra("return-data", true);
//        intent.putExtra("noFaceDetection", true);
//        activity.startActivityForResult(intent, SHEAR);
//    }



////相机
//    private final int CAMERA = 0x1001;
//    //相册
//    private final int ALBUM = 0x1002;
//    //对图片裁剪（剪切）
//    private final int SHEAR = 0x1003;
//
//    @Override
//    public void onClick(View v) {
//        if (picUtils == null) {
//            picUtils = new ImgUpLoadUtils(getActivity());
//        }
//        switch (v.getId()) {
//            case R.id.item_sure://更换头像
//                    picUtils.startAlbum(ALBUM);
//                break;
//            case R.id.item_cancle:
//                    picUtils.startCamer(CAMERA);
//                break;
//        }
//    }
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        switch (requestCode){
//            case ALBUM:
//                //相册选择之后进行裁剪
//                picUtils.shearPic(data,SHEAR);
//                break;
//            case SHEAR:
//                //裁剪
//                //将base64上传
//                updateHead(picUtils.getImgUrl(data));
//                break;
//            case CAMERA:
//                //相机拍照直接上传
//                //将base64上传
//                updateHead(picUtils.getImgUrl(data));
//        }
//        super.onActivityResult(requestCode, resultCode, data);
//    }

}
