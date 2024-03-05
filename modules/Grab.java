package org.firstinspires.ftc.teamcode.modules;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Grab {
    Telemetry telemetry; LinearOpMode L; HardwareMap hwmp;
    public void initFields(Telemetry telemetry, LinearOpMode L, HardwareMap hwmp) { this.telemetry = telemetry; this.L = L; this.hwmp = hwmp; }

    DcMotor RZ, LZ;
    public void init() {
        RZ = hwmp.get(DcMotor.class, "RZ");
        LZ = hwmp.get(DcMotor.class, "LZ");
    }
    public void setPower(double pw) { // положительное - загреб, отрицательное - выгреб
        RZ.setPower(pw);
        LZ.setPower(-pw);
    }
}
