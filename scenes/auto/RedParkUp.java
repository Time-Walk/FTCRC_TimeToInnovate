package org.firstinspires.ftc.teamcode.scenes.auto;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.func.classes.DRP;
import org.firstinspires.ftc.teamcode.func.classes.RPD;
import org.firstinspires.ftc.teamcode.modules.superclasses.RobotConstruct;
@Config
@Autonomous(name="RedParkUp", group="")
public class RedParkUp extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        RobotConstruct R = new RobotConstruct();
        R.init(telemetry, this, hardwareMap);
        waitForStart();
        DRP drp = new DRP();
        drp.init(R, this);
        RPD rpd = new RPD();
        rpd.init(R, this);
        //okay, let's go!

        drp.go(drp.toTicks(-7),drp.toTicks(7));
        R.imu.delay(1000);
        rpd.rotate(90);
        R.imu.delay(1000);
        drp.go(drp.toTicks(180), 0);


    }

}
