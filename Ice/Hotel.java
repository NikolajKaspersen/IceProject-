package Ice;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

class Hotel {
    Holder hotel_ob = new Holder();
    Scanner sc = new Scanner(System.in);

    void CustDetails(int i, int rn)
    {
        String name, contact, gender;
        String name2 = null, contact2 = null;
        String gender2 = "";
        System.out.print("\nIndtast kundenavn: ");
        name = sc.next();
        System.out.print("Indtast kontaktnummer: ");
        contact = sc.next();
        System.out.print("Indtast køn: ");
        gender = sc.next();
        if (i < 3) {
            System.out.print("Indtast andet kundenavn: ");
            name2 = sc.next();
            System.out.print("Indtast kontaktnummer: ");
            contact2 = sc.next();
            System.out.print("Indtast køn: ");
            gender2 = sc.next();
        }

        switch (i)
        {
            case 1:
                hotel_ob.luxury_doublerrom[rn] = new Doubleroom(name, contact, gender, name2, contact2, gender2);
                break;
            case 2:
                hotel_ob.deluxe_doublerrom[rn] = new Doubleroom(name, contact, gender, name2, contact2, gender2);
                break;
            case 3:
                hotel_ob.luxury_singleerrom[rn] = new Singleroom(name, contact, gender);
                break;
            case 4:
                hotel_ob.deluxe_singleerrom[rn] = new Singleroom(name, contact, gender);
                break;
            default:
                System.out.println("Ugyldigt valg");
                break;
        }
    }

    void bookroom(int i)
    {
        int j;
        int rn;
        System.out.println("\nVaelg vaerelsesnummer fra: ");
        switch (i) {
            case 1:
                for (j = 0; j < hotel_ob.luxury_doublerrom.length; j++) {
                    if (hotel_ob.luxury_doublerrom[j] == null)
                    {
                        System.out.print(j + 1 + ",");
                    }
                }
                System.out.print("\nIndtast vaerelsesnummer: ");
                try
                {
                    rn = sc.nextInt();
                    rn--;
                    if (hotel_ob.luxury_doublerrom[rn] != null)
                        throw new NotAvailable();
                    CustDetails(i, rn);
                }
                catch (Exception e)
                {
                    System.out.println("Ugyldigt valg");
                    return;
                }
                break;
            case 2:
                for (j = 0; j < hotel_ob.deluxe_doublerrom.length; j++)
                {
                    if (hotel_ob.deluxe_doublerrom[j] == null)
                    {
                        System.out.print(j + 11 + ",");
                    }
                }
                System.out.print("\nIndtast vaerelsesnummer: ");
                try
                {
                    rn = sc.nextInt();
                    rn = rn - 11;
                    if (hotel_ob.deluxe_doublerrom[rn] != null)
                        throw new NotAvailable();
                    CustDetails(i, rn);
                }
                catch (Exception e)
                {
                    System.out.println("Ugyldigt valg");
                    return;
                }
                break;
            case 3:
                for (j = 0; j < hotel_ob.luxury_singleerrom.length; j++)
                {
                    if (hotel_ob.luxury_singleerrom[j] == null)
                    {
                        System.out.print(j + 31 + ",");
                    }
                }
                System.out.print("\nIndtast vaerelsesnummer: ");
                try
                {
                    rn = sc.nextInt();
                    rn = rn - 31;
                    if (hotel_ob.luxury_singleerrom[rn] != null)
                        throw new NotAvailable();
                    CustDetails(i, rn);
                }
                catch (Exception e)
                {
                    System.out.println("Ugyldigt valg");
                    return;
                }
                break;
            case 4:
                for (j = 0; j < hotel_ob.deluxe_singleerrom.length; j++)
                {
                    if (hotel_ob.deluxe_singleerrom[j] == null)
                    {
                        System.out.print(j + 41 + ",");
                    }
                }
                System.out.print("\nIndtast vaerelsesnummer: ");
                try
                {
                    rn = sc.nextInt();
                    rn = rn - 41;
                    if (hotel_ob.deluxe_singleerrom[rn] != null)
                        throw new NotAvailable();
                    CustDetails(i, rn);
                }
                catch (Exception e)
                {
                    System.out.println("Ugyldigt valg");
                    return;
                }
                break;
            default:
                System.out.println("Indtast gyldigt valg");
                break;
        }
        System.out.println("Vaerelse reserveret");
    }

    void features(int i)
    {
        switch (i)
        {
            case 1:
                System.out.println("Antal dobbeltsenge: 1\nAC: Ja\nGratis morgenmad: Ja\nGebyr pr. dag: 4000 ");
                break;
            case 2:
                System.out.println("Antal dobbeltsenge: 1\nAC: Nej\nGratis morgenmad: Ja\nGebyr pr. dag: 3000  ");
                break;
            case 3:
                System.out.println("Antal dobbeltsenge: 1\nAC: Ja\nGratis morgenmad: Ja\nGebyr pr. dag: 2200  ");
                break;
            case 4:
                System.out.println("Antal dobbeltsenge: 1\nAC: Nej\nGratis morgenmad: Ja\nGebyr pr. dag: 1200 ");
                break;
            default:
                System.out.println("Indtast gyldigt valg");
                break;
        }
    }

    void availability(int i)
    {
        int j, count = 0;
        switch (i) {
            case 1:
                for (j = 0; j < 10; j++)
                {
                    if (hotel_ob.luxury_doublerrom[j] == null)
                        count++;
                }
                break;
            case 2:
                for (j = 0; j < hotel_ob.deluxe_doublerrom.length; j++)
                {
                    if (hotel_ob.deluxe_doublerrom[j] == null)
                        count++;
                }
                break;
            case 3:
                for (j = 0; j < hotel_ob.luxury_singleerrom.length; j++)
                {
                    if (hotel_ob.luxury_singleerrom[j] == null)
                        count++;
                }
                break;
            case 4:
                for (j = 0; j < hotel_ob.deluxe_singleerrom.length; j++)
                {
                    if (hotel_ob.deluxe_singleerrom[j] == null)
                        count++;
                }
                break;
            default:
                System.out.println("Indtast gyldigt valg");
                break;
        }
        System.out.println("Antal ledige vaerelser: " + count);
    }

    void bill(int rn, int rtype)
    {
        double amount = 0;
        String list[] = {"Sandwich", "Pasta", "Nudler", "Cola"};
        System.out.println("\n*******");
        System.out.println(" Regning:-");
        System.out.println("*******");

        switch (rtype)
        {
            case 1:
                amount += 4000;
                System.out.println("\nVaerelsespris - " + 4000);
                System.out.println("\n===============");
                System.out.println("Pris for mad:- ");
                System.out.println("===============");
                System.out.println("Vare   Maengde    Pris");
                System.out.println("-------------------------");
                for (Food obb : hotel_ob.luxury_doublerrom[rn].food)
                {
                    amount += obb.price;
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format, list[obb.itemno - 1], obb.quantity, obb.price);
                }

                break;
            case 2:
                amount += 3000;
                System.out.println("Vaerelsespris - " + 3000);
                System.out.println("\nPris for mad:- ");
                System.out.println("===============");
                System.out.println("Vare   Maengde    Pris");
                System.out.println("-------------------------");
                for (Food obb : hotel_ob.deluxe_doublerrom[rn].food)
                {
                    amount += obb.price;
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format, list[obb.itemno - 1], obb.quantity, obb.price);
                }
                break;
            case 3:
                amount += 2200;
                System.out.println("Vaerelsespris - " + 2200);
                System.out.println("\nPris for mad:- ");
                System.out.println("===============");
                System.out.println("Vare   Maengde    Pris");
                System.out.println("-------------------------");
                for (Food obb : hotel_ob.luxury_singleerrom[rn].food)
                {
                    amount += obb.price;
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format, list[obb.itemno - 1], obb.quantity, obb.price);
                }
                break;
            case 4:
                amount += 1200;
                System.out.println("Vaerelsespris - " + 1200);
                System.out.println("\nPris for mad:- ");
                System.out.println("===============");
                System.out.println("Vare   Maengde    Pris");
                System.out.println("-------------------------");
                for (Food obb : hotel_ob.deluxe_singleerrom[rn].food)
                {
                    amount += obb.price;
                    String format = "%-10s%-10s%-10s%n";
                    System.out.printf(format, list[obb.itemno - 1], obb.quantity, obb.price);
                }
                break;
            default:
                System.out.println("Ikke gyldig");
        }
        System.out.println("\nTotal beløb- " + amount);
    }

    void deallocate(int rn, int rtype)
    {
        int j;
        char w;
        switch (rtype)
        {
            case 1:
                if (hotel_ob.luxury_doublerrom[rn] != null)
                    System.out.println("Vaerelse brugt af " + hotel_ob.luxury_doublerrom[rn].name);
                else
                {
                    System.out.println("Allerede tom");
                    return;
                }
                System.out.println(" Vil du gå til kassen? (j/n)");
                w = sc.next().charAt(0);
                if (w == 'j' || w == 'J')
                {
                    bill(rn, rtype);
                    hotel_ob.luxury_doublerrom[rn] = null;
                    System.out.println("Deallokeret med succes");
                }

                break;
            case 2:
                if (hotel_ob.deluxe_doublerrom[rn] != null)
                    System.out.println("Vaerelse brugt af " + hotel_ob.deluxe_doublerrom[rn].name);
                else
                {
                    System.out.println("Allerede tom");
                    return;
                }
                System.out.println(" Vil du gå til kassen? (j/n)");
                w = sc.next().charAt(0);
                if (w == 'j' || w == 'J')
                {
                    bill(rn, rtype);
                    hotel_ob.deluxe_doublerrom[rn] = null;
                    System.out.println("Deallokeret med succes");
                }

                break;
            case 3:
                if (hotel_ob.luxury_singleerrom[rn] != null)
                    System.out.println("Vaerelse brugt af " + hotel_ob.luxury_singleerrom[rn].name);
                else
                {
                    System.out.println("Allerede tom");
                    return;
                }
                System.out.println(" Vil du gå til kassen? (j/n)");
                w = sc.next().charAt(0);
                if (w == 'j' || w == 'J')
                {
                    bill(rn, rtype);
                    hotel_ob.luxury_singleerrom[rn] = null;
                    System.out.println("Deallokeret med succes");
                }

                break;
            case 4:
                if (hotel_ob.deluxe_singleerrom[rn] != null)
                    System.out.println("Vaerelse brugt af " + hotel_ob.deluxe_singleerrom[rn].name);
                else
                {
                    System.out.println("Allerede tom");
                    return;
                }
                System.out.println(" Vil du gå til kassen? (j/n)");
                w = sc.next().charAt(0);
                if (w == 'j' || w == 'J')
                {
                    bill(rn, rtype);
                    hotel_ob.deluxe_singleerrom[rn] = null;
                    System.out.println("Deallokeret med succes");
                }
                break;
            default:
                System.out.println("\nIndtast gyldigt valg: ");
                break;
        }
    }

    void order(int rn, int rtype)
    {
        int i, q;
        char wish;
        try
        {
            System.out.println("\n==========\n   Menu:  \n==========\n\n1.Sandwich\tRs.50\n2.Pasta\t\tRs.60\n3.Nudler\tRs.70\n4.Cola\t\tRs.30\n");
            do
            {
                i = sc.nextInt();
                System.out.print("Antal- ");
                q = sc.nextInt();

                switch (rtype)
                {
                    case 1:
                        hotel_ob.luxury_doublerrom[rn].food.add(new Food(i, q));
                        break;
                    case 2:
                        hotel_ob.deluxe_doublerrom[rn].food.add(new Food(i, q));
                        break;
                    case 3:
                        hotel_ob.luxury_singleerrom[rn].food.add(new Food(i, q));
                        break;
                    case 4:
                        hotel_ob.deluxe_singleerrom[rn].food.add(new Food(i, q));
                        break;
                }
                System.out.println("Vil du bestille noget andet? (j/n)");
                wish = sc.next().charAt(0);
            }
            while (wish == 'j' || wish == 'J');
        }
        catch (NullPointerException e)
        {
            System.out.println("\nVaerelse ikke reserveret");
        }
        catch (Exception e)
        {
            System.out.println("Kan ikke lade sig gøre");
        }
    }

    void HotelManagement()
    {
        try
        {
            File f = new File("backup");
            if (f.exists())
            {
                FileInputStream fin = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fin);
                Hotel.hotel_ob = (Holder) ois.readObject();
            }
            Scanner sc = new Scanner(System.in);
            int ch, ch2;
            char wish;
            x:
            do
            {

                System.out.println("\nIndtast dit valg:\n1.Vis vaerelsesdetaljer\n2.Vis tilgaengelighed af vaerelse \n3.Book\n4.Bestil mad\n5.Checkout\n6.Afslut\n");
                ch = sc.nextInt();
                switch (ch)
                {
                    case 1:
                        System.out.println("\nVaelg vaerelsestype:\n1.Luksusdobbeltvaerelse \n2.Deluxe-dobbeltvaerelse \n3.Luksusenkeltvaerelse \n4.Deluxe-enkeltvaerelse\n");
                        ch2 = sc.nextInt();
                        Hotel.features(ch2);
                        break;
                    case 2:
                        System.out.println("\nVaelg vaerelsestype:\n1.Luksusdobbeltvaerelse \n2.Deluxe-dobbeltvaerelse \n3.Luksusenkeltvaerelse \n4.Deluxe-enkeltvaerelse\n");
                        ch2 = sc.nextInt();
                        Hotel.availability(ch2);
                        break;
                    case 3:
                        System.out.println("\nVaelg vaerelsestype:\n1.Luksusdobbeltvaerelse \n2.Deluxe-dobbeltvaerelse \n3.Luksusenkeltvaerelse \n4.Deluxe-enkeltvaerelse\n");
                        ch2 = sc.nextInt();
                        Hotel.bookroom(ch2);
                        break;
                    case 4:
                        System.out.print("Vaerelsesnummer -");
                        ch2 = sc.nextInt();
                        if (ch2 > 60)
                            System.out.println("Vaerelset eksisterer ikke");
                        else if (ch2 > 40)
                            Hotel.order(ch2 - 41, 4);
                        else if (ch2 > 30)
                            Hotel.order(ch2 - 31, 3);
                        else if (ch2 > 10)
                            Hotel.order(ch2 - 11, 2);
                        else if (ch2 > 0)
                            Hotel.order(ch2 - 1, 1);
                        else
                            System.out.println("Vaerelset eksisterer ikke");
                        break;
                    case 5:
                        System.out.print("Vaerelsesnummer -");
                        ch2 = sc.nextInt();
                        if (ch2 > 60)
                            System.out.println("Vaerelset eksisterer ikke");
                        else if (ch2 > 40)
                            Hotel.deallocate(ch2 - 41, 4);
                        else if (ch2 > 30)
                            Hotel.deallocate(ch2 - 31, 3);
                        else if (ch2 > 10)
                            Hotel.deallocate(ch2 - 11, 2);
                        else if (ch2 > 0)
                            Hotel.deallocate(ch2 - 1, 1);
                        else
                            System.out.println("Vaerelset eksisterer ikke");
                        break;
                    case 6:
                        break x;
                }

                System.out.println("\nFortsaet : (j/n)");
                wish = sc.next().charAt(0);
                if (!(wish == 'j' || wish == 'J' || wish == 'n' || wish == 'N')) {
                    System.out.println("Ugyldigt valg");
                    System.out.println("\nFortsaet : (j/n)");
                    wish = sc.next().charAt(0);
                }
            }
            while (wish == 'j' || wish == 'J');

            Thread t = new Thread(new Write(Hotel.hotel_ob));
            t.start();
        }
        catch (Exception e)
        {
            System.out.println("Ikke et gyldigt input");
        }
    }
}
