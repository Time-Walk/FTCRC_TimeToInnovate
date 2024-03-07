package org.firstinspires.ftc.teamcode.modules;
import static com.qualcomm.hardware.bosch.BNO055IMU.AngleUnit.DEGREES;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class IMU {
    BNO055IMU imu;
    Telemetry telemetry; LinearOpMode L; HardwareMap hwmp;
    public void initFields(Telemetry telemetry, LinearOpMode L, HardwareMap hwmp) { this.telemetry = telemetry; this.L = L; this.hwmp = hwmp; }
    void init() { //Инициализация:

        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters(); // инициализация Акселерометра
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json";
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();
        imu = hwmp.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);
        while (!imu.isGyroCalibrated()) { //Калибровка акселерометра
            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            telemetry.addData("Wait", "Calibration"); //Сообщение о калибровке
            telemetry.update();
        }
        telemetry.addData("Done!", "Calibrated"); //Сообщение об окончании калибровки
        telemetry.update();

    }

}
