public class Torple {
    char mode;
    int borts;
    double weight;
    double efficiency;

    public Torple() {
        mode = 'n';
        borts = 0;
        weight = 0;
        efficiency = 0;
    }

    public Torple(char _mode, int _borts, double _efficiency) {
        mode = _mode;
        borts = _borts;
        efficiency = _efficiency;
    }

    public Torple genTorple(Torple parent) {
        Torple newTorple = new Torple();
        if (parent.mode == 'A') {
            newTorple.mode = 'B';
        } else {
            newTorple.mode = 'A';
        }
        if (parent.mode == 'A') {
            newTorple.borts = parent.borts;
        } else {
            newTorple.borts = parent.borts++;
        }
        newTorple.weight = parent.weight * parent.efficiency;
        if (parent.borts < 4) {
            newTorple.efficiency = parent.efficiency + 0.05;
        } else if (parent.borts < 9) {
            newTorple.efficiency = parent.efficiency + 0.2;
        } else if (parent.borts < 10) {
            newTorple.efficiency = parent.efficiency + 0.8;
        } else {
            newTorple.efficiency = 0.5;
        }
        return newTorple;
    }
}
