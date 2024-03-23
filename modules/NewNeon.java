package org.firstinspires.ftc.teamcode.modules;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DigitalChannel;

import org.firstinspires.ftc.teamcode.modules.superclasses.Module;

@Config
public class NewNeon extends Module {
    DigitalChannel LEDL, LEDR;
    public static int LED_COUNT_L, LED_COUNT_R;
    int[][] LedL, LedR;
    boolean _send = false;
    public void init() {
        LEDL = hwmp.get(DigitalChannel.class, "LEDL");
        LEDL.setMode(DigitalChannel.Mode.OUTPUT);
        LEDR = hwmp.get(DigitalChannel.class, "LEDR");
        LEDR.setMode(DigitalChannel.Mode.OUTPUT);
        LedL = new int[LED_COUNT_L][3];
        LedR = new int[LED_COUNT_R][3];
        for (int i=0; i<LED_COUNT_L; i++) {
            LedL[i][0] = 255;
            LedL[i][1] = 255;
            LedL[i][2] = 255;
        }
        for (int i=0; i<LED_COUNT_R; i++) {
            LedR[i][0] = 255;
            LedR[i][1] = 255;
            LedR[i][2] = 255;
        }
    }

    public void send() { _send = true; }

    public Thread Sender = new Thread() {
        void setState(DigitalChannel channel, char state) {
            if ( state == '1' ) {
                channel.setState(true);
                advancedDelay(0, 800);
                channel.setState(false);
                advancedDelay(0, 450);
            }
            else {
                channel.setState(true);
                advancedDelay(0, 400);
                channel.setState(false);
                advancedDelay(0, 850);
            }
        }
        @Override
        public void run() {
            while ( !L.opModeIsActive() && !L.isStopRequested() ) {
                if ( _send ) {
                    _send = false;
                    for (int i=0; i<LedL.length; i++) {
                        char[] GColorBased = Integer.toBinaryString(LedL[i][1]).toCharArray();
                        char[] RColorBased = Integer.toBinaryString(LedL[i][0]).toCharArray();
                        char[] BColorBased = Integer.toBinaryString(LedL[i][2]).toCharArray();

                        setState(LEDL, GColorBased[7]);
                        setState(LEDL, GColorBased[6]);
                        setState(LEDL, GColorBased[5]);
                        setState(LEDL, GColorBased[4]);
                        setState(LEDL, GColorBased[3]);
                        setState(LEDL, GColorBased[2]);
                        setState(LEDL, GColorBased[1]);
                        setState(LEDL, GColorBased[0]);
                        setState(LEDL, RColorBased[7]);
                        setState(LEDL, RColorBased[6]);
                        setState(LEDL, RColorBased[5]);
                        setState(LEDL, RColorBased[4]);
                        setState(LEDL, RColorBased[3]);
                        setState(LEDL, RColorBased[2]);
                        setState(LEDL, RColorBased[1]);
                        setState(LEDL, RColorBased[0]);
                        setState(LEDL, BColorBased[7]);
                        setState(LEDL, BColorBased[6]);
                        setState(LEDL, BColorBased[5]);
                        setState(LEDL, BColorBased[4]);
                        setState(LEDL, BColorBased[3]);
                        setState(LEDL, BColorBased[2]);
                        setState(LEDL, BColorBased[1]);
                        setState(LEDL, BColorBased[0]);

                        advancedDelay(0, 50000);

                    }
                    for (int i=0; i<LedR.length; i++) {
                        char[] GColorBased = Integer.toBinaryString(LedR[i][1]).toCharArray();
                        char[] RColorBased = Integer.toBinaryString(LedR[i][0]).toCharArray();
                        char[] BColorBased = Integer.toBinaryString(LedR[i][2]).toCharArray();

                        setState(LEDR, GColorBased[7]);
                        setState(LEDR, GColorBased[6]);
                        setState(LEDR, GColorBased[5]);
                        setState(LEDR, GColorBased[4]);
                        setState(LEDR, GColorBased[3]);
                        setState(LEDR, GColorBased[2]);
                        setState(LEDR, GColorBased[1]);
                        setState(LEDR, GColorBased[0]);
                        setState(LEDR, RColorBased[7]);
                        setState(LEDR, RColorBased[6]);
                        setState(LEDR, RColorBased[5]);
                        setState(LEDR, RColorBased[4]);
                        setState(LEDR, RColorBased[3]);
                        setState(LEDR, RColorBased[2]);
                        setState(LEDR, RColorBased[1]);
                        setState(LEDR, RColorBased[0]);
                        setState(LEDR, BColorBased[7]);
                        setState(LEDR, BColorBased[6]);
                        setState(LEDR, BColorBased[5]);
                        setState(LEDR, BColorBased[4]);
                        setState(LEDR, BColorBased[3]);
                        setState(LEDR, BColorBased[2]);
                        setState(LEDR, BColorBased[1]);
                        setState(LEDR, BColorBased[0]);

                        advancedDelay(0, 50000);

                    }
                    advancedDelay(0, 100000);
                }
            }
        }
    };
}
