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
            drp.go(-1250, -1250);
            R.ap.PPOpen();
            R.ap.delay(750);
            drp.go(1250, 1250);
        }
        else if ( pipe.getResult() == DetectionPipeline.resultPosition.LEFT ) {
            drp.go(-1000, -1750);
            R.ap.PPOpen();
            R.ap.delay(750);
            drp.go(1000, 1750);
        }
        else if ( pipe.getResult() == DetectionPipeline.resultPosition.RIGHT ) {
            drp.go(-1750, -1000);
            R.ap.PPOpen();
            R.ap.delay(750);
            drp.go(1750, 1000);
        }

        R.wb.timer(-.2, -.2, .2, .2, 300);
        rpd.rotate(90);

        if ( pipe.getResult() == DetectionPipeline.resultPosition.CENTER ) {
            drp.go(-1250, -1000);
            R.ap.autoYellowStand();
            R.wb.timer(.3, -.3, .3, -.3, 500);
            R.wb.timer(.3, .3, -.3, -.3, 350);
        }
        else if ( pipe.getResult() == DetectionPipeline.resultPosition.LEFT ) {
            drp.go(-1000, -1000);
            R.ap.autoYellowStand();
            R.wb.timer(.3, -.3, .3, -.3, 500);
            R.wb.timer(.3, .3, -.3, -.3, 350);
        }
        else if ( pipe.getResult() == DetectionPipeline.resultPosition.RIGHT ) {
            drp.go(-1500, -1000);
            R.ap.autoYellowStand();
            R.wb.timer(.3, -.3, .3, -.3, 500);
            R.wb.timer(.3, .3, -.3, -.3, 350);
        }


    }

}
