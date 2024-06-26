package org.firstinspires.ftc.teamcode.modules.camera;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.modules.superclasses.Module;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvPipeline;

public class CameraOut extends Module {
    public OpenCvCamera camera;
    public void init() {
        int cameraMonitorViewId = hwmp.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hwmp.appContext.getPackageName());
        // получение Id монитора камеры
        WebcamName webcamName = hwmp.get(WebcamName.class, "Webcam"); // получение имени камеры из конфига
        camera = OpenCvCameraFactory.getInstance().createWebcam(webcamName, cameraMonitorViewId); // получение экземпляра камеры
    }

    public void openWithPipeline(OpenCvPipeline pipe, boolean isStreamToDash) {
        telemetry.addData("camera", "started open");
        telemetry.update();
        camera.setPipeline(pipe);
        camera.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            @Override
            public void onOpened() {
                camera.startStreaming(640, 480, OpenCvCameraRotation.UPRIGHT);
                if ( isStreamToDash ) {
                    FtcDashboard dash = FtcDashboard.getInstance();
                    dash.startCameraStream(camera, 30);
                }
                telemetry.addData("camera", "opened");
                telemetry.update();
            }

            @Override
            public void onError(int errorCode) {

            }
        });
    }
}
