package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice12CameraRotateFixedView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);
    int centerX1,centerY1,centerX2,centerY2;

    public Practice12CameraRotateFixedView(Context context) {
        super(context);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        int x = bitmap.getWidth();
        int y = bitmap.getHeight();
        centerX1 = point1.x+x/2;
        centerY1 = point1.y+y/2;
        centerX2 = point2.x+x/2;
        centerY2 = point2.y+y/2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Camera camera = new Camera();

        canvas.save();

        camera.save();
        camera.rotateX(30);
        canvas.translate(centerX1,centerY1);
        camera.applyToCanvas(canvas);
        canvas.translate(-centerX1,-centerY1);
        camera.restore();
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);

        canvas.restore();
        canvas.save();

        camera.save();
        camera.rotateY(30);
        canvas.translate(centerX2,centerY2);
        camera.applyToCanvas(canvas);
        canvas.translate(-centerX2,-centerY2);
        camera.restore();
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);

        canvas.restore();
    }
}
