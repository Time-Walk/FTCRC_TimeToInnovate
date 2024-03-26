package org.firstinspires.ftc.teamcode.scenes.auto;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.func.classes.RPD;
import org.firstinspires.ftc.teamcode.modules.superclasses.RobotConstruct;

@Config
@Autonomous(name="RotDash", group="")
public class RotDash extends LinearOpMode {
    public static double angle = 90;
    @Override
    public void runOpMode() throws InterruptedException {
        RobotConstruct R = new RobotConstruct();
        R.init(telemetry, this, hardwareMap);
        waitForStart();

        //okay, let's go!

        RPD rpd = new RPD();
        rpd.init(R, this);
        rpd.rotate(angle);

    }

}
