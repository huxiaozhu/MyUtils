//要引入的包 compile 'com.google.zxing:core:3.3.0'

//要填充的图片
Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_launcher);
//填充图片的二维码
img.setImageBitmap(ZXingUtils.createQRImage(QR, 300, bitmap));
//中间不填充图片的二维码
//img.setImageBitmap(ZXingUtils.createQRImage(QR, 300, null));