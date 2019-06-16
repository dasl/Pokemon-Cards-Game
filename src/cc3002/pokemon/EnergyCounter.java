package cc3002.pokemon;

import java.util.EnumMap;
import java.util.Map;

enum EnergyType {
    grass, fire, water, electric, normal, psychic
}

public class EnergyCounter {
    Map<EnergyType, Integer> energies = new EnumMap<>(EnergyType.class);

    public EnergyCounter() {
        for (EnergyType type : EnergyType.values()) {
            energies.put(type, 0);
        }
    }

    public void clear(){
        energies.clear();
    }

    public void setGrassEnergy() {
        int aux = getGrassEnergy();
        aux++;
        energies.put(EnergyType.grass, aux);
    }

    public int getGrassEnergy() {
        return energies.get(EnergyType.grass);
    }

    public void setFireEnergy() {
        int aux = getFireEnergy();
        aux++;
        energies.put(EnergyType.fire, aux);
    }
    public int getFireEnergy() {
        return energies.get(EnergyType.fire);
    }

    public void setWaterEnergy() {
        int aux = getWaterEnergy();
        aux++;
        energies.put(EnergyType.water, aux);
    }
    public int getWaterEnergy() {
        return energies.get(EnergyType.water);
    }

    public void setElectricEnergy() {
        int aux = getElectricEnergy();
        aux++;
        energies.put(EnergyType.electric, aux);
    }
    public int getElectricEnergy() {
        return energies.get(EnergyType.electric);
    }

    public void setNormalEnergy() {
        int aux = getNormalEnergy();
        aux++;
        energies.put(EnergyType.normal, aux);
    }
    public int getNormalEnergy() {
        return energies.get(EnergyType.normal);
    }

    public void setPsychicEnergy() {
        int aux = getPyshicEnergy();
        aux++;
        energies.put(EnergyType.psychic, aux);
    }
    public int getPyshicEnergy() {
        return energies.get(EnergyType.psychic);
    }

    public boolean greaterThan(EnergyCounter other) {
        for (EnergyType type : EnergyType.values()) {
            if (energies.get(type) < other.energies.get(type)) {
                return false;
            }
        }
        return true;
    }

}
