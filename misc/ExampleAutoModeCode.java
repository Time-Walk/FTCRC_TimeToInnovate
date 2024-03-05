package org.firstinspires.ftc.teamcode.misc;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.modules.RobotConstruct;

//@Autonomous(name="AutoName", group="")
public class ExampleAutoModeCode extends LinearOpMode { //YOU SHOULD CHANGE HERE TO YOUR FILE NAME
    @Override
    public void runOpMode() throws InterruptedException {
        RobotConstruct R = new RobotConstruct();
        R.initFields(telemetry, this, hardwareMap);
        R.init();
        waitForStart();

        //okay, let's go!

    }

}
