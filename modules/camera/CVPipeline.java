package org.firstinspires.ftc.teamcode.modules.camera;

import com.acmerobotics.dashboard.canvas.Image;
import com.acmerobotics.dashboard.config.Config;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

@Config
public class CVPipeline extends OpenCvPipeline {

    public static double fx = 601.32512335;
    public static double fy = 605.96041909;
    public static double cx = 379.76580887;
    public static double cy = 1;
    public static double lh = 57;
    public static double ls = 48;
    public static double lv = 82;
    public static double hh = 72;
    public static double hs = 234;
    public static double hv = 210;
    public static double HeightOfCamera = 16.5;
    public static double RotDownOfCamera = 63.25;

    public double XDist = 0;
    public double YDist = 0;

    Telemetry telemetry;

    public void setTelemtry(Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    public static double[][] multiplyByMatrix(double[][] m1, double[][] m2) {
        int m1ColLength = m1[0].length; // m1 columns length
        int m2RowLength = m2.length;    // m2 rows length
        if (m1ColLength != m2RowLength) return null; // matrix multiplication is not possible
        int mRRowLength = m1.length;    // m result rows length
        int mRColLength = m2[0].length; // m result columns length
        double[][] mResult = new double[mRRowLength][mRColLength];
        for (int i = 0; i < mRRowLength; i++) {     // rows from m1
            for (int j = 0; j < mRColLength; j++) {   // columns from m2
                for (int k = 0; k < m1ColLength; k++) { // columns from m1
                    mResult[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return mResult;
    }



    public double[] pic2r(double alpha, double beta, double x, double y, double h) {
        double y_s_shapochkoy = h * (1/Math.tan(Math.atan((y-cy)/fy)+beta));
        double x_s_shapochkoy = (y_s_shapochkoy*(x-cx))/(fx);

        double[][] rotate_matrix = {{Math.cos(alpha), -Math.sin(alpha)}, {Math.sin(alpha), Math.cos(alpha)}};
        double[][] xy_s_shapochkamy = {{x_s_shapochkoy},{y_s_shapochkoy}};

        double[][] xyM = multiplyByMatrix(rotate_matrix,xy_s_shapochkamy);

        double[] xy = new double[2];
        xy[0] = xyM[0][0];
        xy[1] = xyM[1][0];

        return xy;
    }

    double[] getDist(Mat input) {
        double x = 0, y = 0;
        Mat frameYCrCb = new Mat();
        Mat outputFrame = new Mat();
        Mat frameblur = new Mat();
        Imgproc.blur(input, frameblur,  new Size(7, 7), new Point(-1, -1));
        Imgproc.cvtColor(frameblur, frameYCrCb, Imgproc.COLOR_BGR2HSV);
        Scalar minValues = new Scalar(lh, ls, lv);
        Scalar maxValues = new Scalar(hh, hs, hv);
        Mat mask = new Mat();
        Core.inRange(frameYCrCb, minValues, maxValues, mask);
        int connectivity = 4;
        Mat labels = new Mat();
        Mat stats = new Mat();
        Mat _ = new Mat();
        int labels_num = Imgproc.connectedComponentsWithStats(mask, labels, stats, _, connectivity, CvType.CV_32S);
        telemetry.addData("labeles_num", labels_num);
        //output = Imgproc.connectedComponents(frameYCrCb, mask, 4);
        for (int i=0; i<labels_num; i++) {
            double a = stats.get(i, Imgproc.CC_STAT_AREA)[0];
            double t = stats.get(i, Imgproc.CC_STAT_TOP)[0];
            double l = stats.get(i, Imgproc.CC_STAT_LEFT)[0];
            double w = stats.get(i, Imgproc.CC_STAT_WIDTH)[0];
            double h = stats.get(i, Imgproc.CC_STAT_HEIGHT)[0];
            if (a >= 2000) {
                x = l + (int) Math.floor(w / 2);
                y = t + (int) Math.floor(h / 2);
                break;
            }
        }
       double[] xy = pic2r( 0, Math.toRadians(90 - RotDownOfCamera), x, y, HeightOfCamera);
        telemetry.addData("x", x);
        telemetry.addData("y", y);
        telemetry.update();
       return xy;
    }
    @Override
    public Mat processFrame(Mat input) {
        double[] xy = getDist(input);
        XDist = xy[0];
        YDist = xy[1];
        return input;
    }
}
