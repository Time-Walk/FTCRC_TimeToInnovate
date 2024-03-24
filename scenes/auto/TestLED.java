package org.firstinspires.ftc.teamcode.scenes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.modules.superclasses.RobotConstruct;

@Autonomous(name="TestLED", group="")
public class TestLED extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        RobotConstruct R = new RobotConstruct();
        R.init(telemetry, this, hardwareMap);
        waitForStart();

        //okay, let's go!

        for (int i=0; i<R.led.LedL.length; i++) {
            R.led.LedL[i][0] = 0;
            R.led.LedL[i][1] = 0;
            R.led.LedL[i][2] = 0;
            R.led.delay(500);
        }

    }

}
