package com.hospital.storage.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "medicine",
    propOrder = {"id","name", "usage"}
)
public final class Medicine {
    @XmlElement(
        required = true
    )

    private String name;
    @XmlElement(
        required = true
    )
    private int id;
    @XmlElement(
        required = true
    )
    private String usage;

    public Medicine() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int value) {
        this.id = value;
    }

    public String getUsage() {
        return this.usage;
    }

    public void setUsage(String value) {
        this.usage = value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Medicine medicine = (Medicine) o;

        if (id != medicine.id) {
            return false;
        }
        if (name != null ? !name.equals(medicine.name) : medicine.name != null) {
            return false;
        }
        return usage != null ? usage.equals(medicine.usage) : medicine.usage == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + (usage != null ? usage.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Medicine{");
        sb.append("name='").append(name).append('\'');
        sb.append(", id=").append(id);
        sb.append(", usage='").append(usage).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

