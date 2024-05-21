package org.firstinspires.ftc.teamcode.scenes.auto;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.checkerframework.checker.units.qual.C;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.modules.camera.CVPipeline;
import org.firstinspires.ftc.teamcode.modules.superclasses.RobotConstruct;

@Autonomous(name="подсчет до зеленого гада", group="")
public class CalculationDistToGreenPixel extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        RobotConstruct R = new RobotConstruct();
        R.init(telemetry, this, hardwareMap);

        Telemetry telemetry = FtcDashboard.getInstance().getTelemetry();

        CVPipeline pipe = new CVPipeline();
        pipe.setTelemtry(telemetry);

        R.cameraOut.openWithPipeline(pipe, true);

        waitForStart();

        //okay, let's go!

        while ( this.opModeIsActive() ) {
            telemetry.addData("XDist", pipe.XDist);
            telemetry.addData("YDist", pipe.YDist);
        }//telemetry.update(); }

    }

}

