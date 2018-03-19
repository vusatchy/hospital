package com.hospital.storage.models;

public final class Medicine {

    private final int id;

    private final String name;

    private final String usage;

    public Medicine(int id, String name, String usage) {
        this.id = id;
        this.name = name;
        this.usage = usage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsage() {
        return usage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Medicine medicine = (Medicine) o;

        if (id != medicine.id) return false;
        if (name != null ? !name.equals(medicine.name) : medicine.name != null) return false;
        return usage != null ? usage.equals(medicine.usage) : medicine.usage == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (usage != null ? usage.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Medicine{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", usage='").append(usage).append('\'');
        sb.append('}');
        return sb.toString();
    }
}