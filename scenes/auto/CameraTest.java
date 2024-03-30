package org.firstinspires.ftc.teamcode.scenes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.modules.camera.DetectionPipeline;
import org.firstinspires.ftc.teamcode.modules.superclasses.RobotConstruct;

@Autonomous(name="CameraTest", group="")
public class CameraTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        RobotConstruct R = new RobotConstruct();
        R.init(telemetry, this, hardwareMap);

        DetectionPipeline pipe = new DetectionPipeline();
        pipe.targetColor = "BLUE";
        pipe.initFixed(telemetry);

        R.cameraOut.openWithPipeline(pipe, true);

        while (!isStarted() && !isStopRequested()) {
            telemetry.addData("result", pipe.getResult());
            //telemetry.update();
            R.wb.delay(500);
        }


        //okay, let's go!

    }

}
