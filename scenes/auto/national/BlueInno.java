package org.firstinspires.ftc.teamcode.scenes.auto.national;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.func.classes.DRP;
import org.firstinspires.ftc.teamcode.func.classes.RPD;
import org.firstinspires.ftc.teamcode.modules.camera.DetectionPipeline;
import org.firstinspires.ftc.teamcode.modules.superclasses.RobotConstruct;

@Autonomous(name="Blue Inno", group="Blue")
public class BlueInno extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        RobotConstruct R = new RobotConstruct();
        R.init(telemetry, this, hardwareMap);

        RPD rpd = new RPD();
        rpd.init(R, this);
        DRP drp = new DRP();
        drp.init(R, this);

        R.ap.PPOpen();

        DetectionPipeline pipe = new DetectionPipeline();
        pipe.targetColor = "BLUE";
        pipe.initFixed(telemetry);

        R.cameraOut.openWithPipeline(pipe, true);

        while (!isStarted() && !isStopRequested()) {
            telemetry.addData("result", pipe.getResult());
            //telemetry.update();
            R.wb.delay(500);
        }

        R.ap.PPClose();

        //okay, let's go!

        if ( pipe.getResult() == DetectionPipeline.resultPosition.CENTER ) {
            drp.go(0, -drp.toTicks(75/Math.sqrt(2)));
            drp.go(-drp.toTicks(75/Math.sqrt(2)), 0);
            R.ap.PPOpen();
            R.ap.delay(750);
            R.wb.timer(-.3, 0, .0, .3, 1500);
        }
        else if ( pipe.getResult() == DetectionPipeline.resultPosition.LEFT ) {
            drp.go(0, -500);
            drp.go(-600, 0);
            R.ap.PPOpen();
            R.ap.delay(750);
            R.wb.timer(-.3, 0, 0, .3, 1500);
        }
        else if ( pipe.getResult() == DetectionPipeline.resultPosition.RIGHT ) {
            drp.go(-875, -500);
            R.ap.PPOpen();
            R.ap.delay(750);
            drp.go(875, 500);
        }

        R.wb.timer(-.2, -.2, .2, .2, 500);
        rpd.rotate(90);

        if ( pipe.getResult() == DetectionPipeline.resultPosition.CENTER ) {
            drp.go(500, -1000);
            R.ap.autoYellowStand();
            R.wb.timer(.3, -.3, .3, -.3, 500);
            R.wb.timer(.3, .3, -.3, -.3, 350);
        }
        else if ( pipe.getResult() == DetectionPipeline.resultPosition.LEFT ) {
            drp.go(750, -1000);
            R.ap.autoYellowStand();
            R.wb.timer(.3, -.3, .3, -.3, 500);
            R.wb.timer(.3, .3, -.3, -.3, 350);
        }
        else if ( pipe.getResult() == DetectionPipeline.resultPosition.RIGHT ) {
            drp.go(250, -1000);
            R.ap.autoYellowStand();
            R.wb.timer(.3, -.3, .3, -.3, 500);
            R.wb.timer(.3, .3, -.3, -.3, 350);
        }


    }

}
