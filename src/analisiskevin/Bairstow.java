/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisiskevin;

/**
 *
 * @author rcarlos
 */
public class Bairstow {

    private double b[];
    private double c[];
    private double r;
    private double s;
    private double errores[];
    private double Es;

    public Bairstow() {
    }

    public Bairstow(double r, double s, double es) {
        this.r = r;
        this.s = s;
        this.Es=es;
    }

//    public void bs(double[] coeficientes, double r, double s) {
//        b = new double[coeficientes.length];
//        for (int i = (coeficientes.length - 1); i >= 0; i--) {
//            if (i == (coeficientes.length - 1)) {
//                b[i] = coeficientes[i];
//                System.out.println("B" + i + ": " + b[i]);
//            } else {
//                if (i == (coeficientes.length - 2)) {
//                    b[i] = coeficientes[i] + (r * b[i + 1]);
//                    System.out.println("B" + i + ": " + b[i]);
//                } else {
//                    b[i] = coeficientes[i] + (r * b[i + 1]) + (s * b[i + 2]);
//                    System.out.println("B" + i + ": " + b[i]);
//                }
//            }
//        }
//    }
//
//    public void cs(double bs[], double r, double s) {
//        c = new double[bs.length];
//        for (int i = (bs.length - 1); i >= 1; i--) {
//            if (i == (bs.length - 1)) {
//                c[i] = bs[i];
//                System.out.println("C" + i + ": " + c[i]);
//            } else {
//                if (i == (bs.length - 2)) {
//                    c[i] = bs[i] + (r * c[i + 1]);
//                    System.out.println("C" + i + ": " + c[i]);
//                } else {
//                    c[i] = bs[i] + (r * c[i + 1]) + (s * c[i + 2]);
//                    System.out.println("C" + i + ": " + c[i]);
//                }
//            }
//        }
//    }
    public double[] vector(double bs[], double r, double s) {
        double ve[] = new double[bs.length];
        for (int i = (bs.length - 1); i >= 0; i--) {
            if (i == (bs.length - 1)) {
                ve[i] = bs[i];
                System.out.println("C" + i + ": " + ve[i]);
            } else {
                if (i == (bs.length - 2)) {
                    ve[i] = bs[i] + (r * ve[i + 1]);
                    System.out.println("C" + i + ": " + ve[i]);
                } else {
                    ve[i] = bs[i] + (r * ve[i + 1]) + (s * ve[i + 2]);
                    System.out.println("C" + i + ": " + ve[i]);
                }
            }
        }
        return ve;
    }

    public double[] error() {
        double ec1[] = {c[2], c[3], -1 * b[1]};
        double ec2[] = {c[1], c[2], -1 * b[0]};

        double Dr;
        for (int i = 0; i < ec1.length; i++) {
            ec1[i] = ec1[i] * c[2];
            ec2[i] = ec2[i] * c[3];
        }
        if (ec1[1] < 0 && ec2[1] < 0) {
            for (int i = 0; i < ec1.length; i++) {
                ec1[i] = ec1[i] * (-1);
            }
        }
        Dr = (ec1[2] + ec2[2]) / (ec1[0] + ec2[0]);
        double Ds;
        ec1[0] = c[2];
        ec1[1] = c[3];
        ec1[2] = -1 * b[1];
        ec2[0] = c[1];
        ec2[1] = c[2];
        ec2[2] = -1 * b[0];
        for (int i = 0; i < ec1.length; i++) {
            ec1[i] = ec1[i] * c[1];
            ec2[i] = ec2[i] * c[2];
        }
        if (ec1[0] < 0 && ec2[0] < 0) {
            for (int i = 0; i < ec1.length; i++) {
                ec1[i] = ec1[i] * (-1);
            }
        }
        Ds = (ec1[2] + ec2[2]) / (ec1[1] + ec2[1]);
        System.out.println("Dr: " + Dr);
        System.out.println("Ds: " + Ds);
        r = r + Dr;
        s = s + Ds;
        double Ear;
        double Eas;
        Ear = (Dr / r) * 100;
        Eas = (Ds / s) * 100;
        if (Ear < 0) {
            Ear = Ear * -1;
        }
        if (Eas < 0) {
            Eas = Eas * -1;
        }
        System.out.println("Ear: " + Ear);
        System.out.println("Eas: " + Eas);
        double ers[] = {Ear, Eas};
        return ers;
    }

    public void metodo(double coeficientes[]) {
        do {
            b = vector(coeficientes, r, s);
            c = vector(b, r, s);
            errores = error();
        } while (errores[0]>Es && errores[1]>Es);
    }
}
