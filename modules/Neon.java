package org.firstinspires.ftc.teamcode.modules;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.modules.superclasses.Module;

public class Neon extends Module {
    DcMotor NE;
    String NeState;
    @Override
    public void init() {
        NE = hwmp.get(DcMotor.class, "NE");
        NeState = "Hold";
    }

    double plinkCount = 0;
    double plinkR = 0;
    double holdR = 0;
    void NESetPower(double power) {
        NE.setPower(Math.abs(power));
    }
    void NeonController() {
        if (NeState == "Driving") {
            double NePower = 0.3;
            NePower += Math.abs(gamepad1.left_stick_x) * 0.2 + Math.abs(gamepad1.left_stick_y) * 0.2 + Math.abs(gamepad1.right_stick_x) * 0.2 + Math.abs(gamepad1.left_stick_y) * 0.2 + Math.abs(gamepad1.left_trigger) * 0.2 + Math.abs(gamepad1.right_trigger) * 0.2;
            NESetPower(NePower);
        }
        if (NeState == "Plink") {
            NESetPower((Math.abs(Math.sin(plinkR)) * 0.7) + 0.2);
            plinkR += 0.01;
            if (plinkR >= 3) {
                plinkCount -= 1;
                plinkR = 0;
            }
            if (plinkCount == 0) {
                NeState = "Driving";
            }
        }
        if (NeState == "Hold") {
            NESetPower(Math.abs(Math.sin(holdR)));
            holdR += 0.003;
        }
    }

    Thread inInitNeonController = new Thread() {
        @Override
        public void run() {
            while (!L.opModeIsActive() && !L.isStopRequested()) {
                NeonController();
            }
        }
    };
}
