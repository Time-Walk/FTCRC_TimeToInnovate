package org.firstinspires.ftc.teamcode.scenes.auto;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.modules.superclasses.RobotConstruct;

//@Autonomous(name="AutoName", group="")
public class TestDigitalDirect extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        RobotConstruct R = new RobotConstruct();
        R.init(telemetry, this, hardwareMap);
        waitForStart();

        //okay, let's go!

    }

}
