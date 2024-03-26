package org.firstinspires.ftc.teamcode.func;

import com.acmerobotics.dashboard.config.Config;

import org.firstinspires.ftc.teamcode.func.classes.superclasses.PD;

@Config
public class ExamplePD {
    PD pd;
    public static double EXkp = .1;
    public static double EXkd = .1;
    void init() {
        pd = new PD();
        pd.init(EXkp, EXkd);
    }
    void move() {
        while (1 > .1) {
            double pw = pd.tick(0.1);
        }
    }
}
