public class Korting {
int korting;
Korting(int korting){
    this.korting = korting;
};
}
class studentenKorting extends Korting{

    studentenKorting(int korting) {
        super(korting);
    }
}

class ledenKorting extends  Korting{
    ledenKorting(int korting) {
        super(korting);
    }
}
