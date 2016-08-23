package com.kami.jobTest;

import java.util.Scanner;

public class ms1 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		float a = in.nextFloat();
		float b = in.nextFloat();
		float r = in.nextFloat();

		int starta = (int) Math.ceil(a - r);
		int startb = (int) Math.floor(b + r);
		int enda = (int) Math.floor(a + r);
		int endb = (int) Math.ceil(b - r);
		double dis = 0, maxdis = -1;
		double rdouble = r * r;
		int maxa = 0, maxb = 0;

		for (int i = starta; i <= enda; i++) {

			for (int j = startb; j >= endb; j += (endb - startb)) {
				// dis = Math.sqrt((i-a)*(i-a)+(j-b)*(j-b));
				dis = (i - a) * (i - a) + (j - b) * (j - b);

				if (Double.compare(dis, rdouble) <= 0) {
					if (Double.compare(dis, maxdis) > 0) {
						maxdis = dis;
						maxa = i;
						maxb = j;
					} else if (Double.compare(dis, maxdis) == 0) {
						if (i > maxa) {
							maxa = i;
							maxb = j;
						} else if (i == maxa) {
							if (j > maxb) {
								maxa = i;
								maxb = j;

							}
						}

					}
				}
			}
		}

		for (int i = startb; i >= endb; i--) {

			for (int j = starta; j <= enda; j += (enda - starta)) {
				// dis = Math.sqrt((i-a)*(i-a)+(j-b)*(j-b));
				dis = (j - a) * (j - a) + (i - b) * (i - b);

				if (Double.compare(dis, rdouble) <= 0) {
					if (Double.compare(dis, maxdis) > 0) {
						maxdis = dis;
						maxa = j;
						maxb = i;
					} else if (Double.compare(dis, maxdis) == 0) {
						if (j > maxa) {
							maxa = j;
							maxb = i;
						} else if (j == maxa) {
							if (i > maxb) {
								maxa = j;
								maxb = i;

							}
						}

					}
				}
			}
		}
		System.out.println(maxa + " " + maxb);
	}

}
