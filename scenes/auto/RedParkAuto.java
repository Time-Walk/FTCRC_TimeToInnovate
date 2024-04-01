package org.firstinspires.ftc.teamcode.scenes.auto;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.func.classes.DRP;
import org.firstinspires.ftc.teamcode.func.classes.RPD;
import org.firstinspires.ftc.teamcode.modules.superclasses.RobotConstruct;
@Config
@Autonomous(name="Продолжение легенды", group="Red")
public class RedParkAuto extends LinearOpMode {
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

       R.wb.timer(.25, .25, -.25, -.25, 300);
       R.wb.timer(.35, -.35, .35, -.35, 1500);


    }

}
