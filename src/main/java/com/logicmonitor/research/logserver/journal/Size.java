package com.logicmonitor.research.logserver.journal;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Size implements Comparable<Size> {
    private static final Pattern SIZE_PATTERN = Pattern.compile("(\\d+)\\s*(\\S+)");
    private static final Map<String, SizeUnit> SUFFIXES = new HashMap();
    private final long count;
    private final SizeUnit unit;

    public static Size bytes(long count) {
        return new Size(count, SizeUnit.BYTES);
    }

    public static Size kilobytes(long count) {
        return new Size(count, SizeUnit.KILOBYTES);
    }

    public static Size megabytes(long count) {
        return new Size(count, SizeUnit.MEGABYTES);
    }

    public static Size gigabytes(long count) {
        return new Size(count, SizeUnit.GIGABYTES);
    }

    public static Size terabytes(long count) {
        return new Size(count, SizeUnit.TERABYTES);
    }

    public static Size petabytes(long count) {
        return new Size(count, SizeUnit.PETABYTES);
    }

    public static Size parse(String size) {
        Matcher matcher = SIZE_PATTERN.matcher(size);
        if(!matcher.matches()) {
            throw new IllegalArgumentException("Invalid size: " + size);
        } else {
            long count = Long.parseLong(matcher.group(1));
            SizeUnit unit = (SizeUnit)SUFFIXES.get(matcher.group(2));
            if(unit == null) {
                throw new IllegalArgumentException("Invalid size: " + size + ". Wrong size unit");
            } else {
                return new Size(count, unit);
            }
        }
    }

    private Size(long count, SizeUnit unit) {
        if(null == unit) {
            throw new NullPointerException("Unit must not be null.");
        } else {
            this.count = count;
            this.unit = unit;
        }
    }

    public long getQuantity() {
        return this.count;
    }

    public SizeUnit getUnit() {
        return this.unit;
    }

    public long toBytes() {
        return SizeUnit.BYTES.convert(this.count, this.unit);
    }

    public long toKilobytes() {
        return SizeUnit.KILOBYTES.convert(this.count, this.unit);
    }

    public long toMegabytes() {
        return SizeUnit.MEGABYTES.convert(this.count, this.unit);
    }

    public long toGigabytes() {
        return SizeUnit.GIGABYTES.convert(this.count, this.unit);
    }

    public long toTerabytes() {
        return SizeUnit.TERABYTES.convert(this.count, this.unit);
    }

    public long toPetabytes() {
        return SizeUnit.PETABYTES.convert(this.count, this.unit);
    }

    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        } else if(!(obj instanceof Size)) {
            return false;
        } else {
            Size size = (Size)obj;
            return this.count == size.count && this.unit == size.unit;
        }
    }

    public int hashCode() {
        return 31 * (int)(this.count ^ this.count >>> 32) + this.unit.hashCode();
    }

    public String toString() {
        String units = this.unit.toString().toLowerCase(Locale.ENGLISH);
        if(this.count == 1L) {
            units = units.substring(0, units.length() - 1);
        }

        return Long.toString(this.count) + ' ' + units;
    }

    public int compareTo(Size other) {
        return this.unit == other.unit?Long.valueOf(this.count).compareTo(Long.valueOf(other.count)):Long.valueOf(this.toBytes()).compareTo(Long.valueOf(other.toBytes()));
    }

    static {
        SUFFIXES.put("b", SizeUnit.BYTES);
        SUFFIXES.put("B", SizeUnit.BYTES);
        SUFFIXES.put("byte", SizeUnit.BYTES);
        SUFFIXES.put("bytes", SizeUnit.BYTES);
        SUFFIXES.put("k", SizeUnit.KILOBYTES);
        SUFFIXES.put("K", SizeUnit.KILOBYTES);
        SUFFIXES.put("kb", SizeUnit.KILOBYTES);
        SUFFIXES.put("KB", SizeUnit.KILOBYTES);
        SUFFIXES.put("KiB", SizeUnit.KILOBYTES);
        SUFFIXES.put("kilobyte", SizeUnit.KILOBYTES);
        SUFFIXES.put("kilobytes", SizeUnit.KILOBYTES);
        SUFFIXES.put("m", SizeUnit.MEGABYTES);
        SUFFIXES.put("M", SizeUnit.MEGABYTES);
        SUFFIXES.put("mb", SizeUnit.MEGABYTES);
        SUFFIXES.put("MB", SizeUnit.MEGABYTES);
        SUFFIXES.put("MiB", SizeUnit.MEGABYTES);
        SUFFIXES.put("megabyte", SizeUnit.MEGABYTES);
        SUFFIXES.put("megabytes", SizeUnit.MEGABYTES);
        SUFFIXES.put("g", SizeUnit.GIGABYTES);
        SUFFIXES.put("G", SizeUnit.GIGABYTES);
        SUFFIXES.put("gb", SizeUnit.GIGABYTES);
        SUFFIXES.put("GB", SizeUnit.GIGABYTES);
        SUFFIXES.put("GiB", SizeUnit.GIGABYTES);
        SUFFIXES.put("gigabyte", SizeUnit.GIGABYTES);
        SUFFIXES.put("gigabytes", SizeUnit.GIGABYTES);
        SUFFIXES.put("t", SizeUnit.TERABYTES);
        SUFFIXES.put("T", SizeUnit.TERABYTES);
        SUFFIXES.put("tb", SizeUnit.TERABYTES);
        SUFFIXES.put("TB", SizeUnit.TERABYTES);
        SUFFIXES.put("TiB", SizeUnit.TERABYTES);
        SUFFIXES.put("terabyte", SizeUnit.TERABYTES);
        SUFFIXES.put("terabytes", SizeUnit.TERABYTES);
        SUFFIXES.put("p", SizeUnit.PETABYTES);
        SUFFIXES.put("P", SizeUnit.PETABYTES);
        SUFFIXES.put("pb", SizeUnit.PETABYTES);
        SUFFIXES.put("PB", SizeUnit.PETABYTES);
        SUFFIXES.put("PiB", SizeUnit.PETABYTES);
        SUFFIXES.put("petabyte", SizeUnit.PETABYTES);
        SUFFIXES.put("petabytes", SizeUnit.PETABYTES);
    }
}
