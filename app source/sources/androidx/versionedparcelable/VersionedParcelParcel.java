package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
class VersionedParcelParcel extends VersionedParcel {
    private static final boolean DEBUG = false;
    private static final String TAG = "VersionedParcelParcel";
    private int mCurrentField;
    private final int mEnd;
    private int mNextRead;
    private final int mOffset;
    private final Parcel mParcel;
    private final SparseIntArray mPositionLookup;
    private final String mPrefix;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    VersionedParcelParcel(android.os.Parcel r8) {
        /*
            r7 = this;
            r0 = r7
            r1 = r8
            r2 = r0
            r3 = r1
            r4 = r1
            int r4 = r4.dataPosition()
            r5 = r1
            int r5 = r5.dataSize()
            java.lang.String r6 = ""
            r2.<init>(r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.versionedparcelable.VersionedParcelParcel.<init>(android.os.Parcel):void");
    }

    VersionedParcelParcel(Parcel p, int offset, int end, String prefix) {
        SparseIntArray sparseIntArray;
        new SparseIntArray();
        this.mPositionLookup = sparseIntArray;
        this.mCurrentField = -1;
        this.mNextRead = 0;
        this.mParcel = p;
        this.mOffset = offset;
        this.mEnd = end;
        this.mNextRead = this.mOffset;
        this.mPrefix = prefix;
    }

    private int readUntilField(int i) {
        int fieldId = i;
        while (this.mNextRead < this.mEnd) {
            this.mParcel.setDataPosition(this.mNextRead);
            int size = this.mParcel.readInt();
            int fid = this.mParcel.readInt();
            this.mNextRead += size;
            if (fid == fieldId) {
                return this.mParcel.dataPosition();
            }
        }
        return -1;
    }

    public boolean readField(int fieldId) {
        int position = readUntilField(fieldId);
        if (position == -1) {
            return false;
        }
        this.mParcel.setDataPosition(position);
        return true;
    }

    public void setOutputField(int i) {
        int fieldId = i;
        closeField();
        this.mCurrentField = fieldId;
        this.mPositionLookup.put(fieldId, this.mParcel.dataPosition());
        writeInt(0);
        writeInt(fieldId);
    }

    public void closeField() {
        if (this.mCurrentField >= 0) {
            int currentFieldPosition = this.mPositionLookup.get(this.mCurrentField);
            int position = this.mParcel.dataPosition();
            this.mParcel.setDataPosition(currentFieldPosition);
            this.mParcel.writeInt(position - currentFieldPosition);
            this.mParcel.setDataPosition(position);
        }
    }

    /* access modifiers changed from: protected */
    public VersionedParcel createSubParcel() {
        StringBuilder sb;
        VersionedParcelParcel versionedParcelParcel = r8;
        Parcel parcel = this.mParcel;
        int dataPosition = this.mParcel.dataPosition();
        int i = this.mNextRead == this.mOffset ? this.mEnd : this.mNextRead;
        new StringBuilder();
        VersionedParcelParcel versionedParcelParcel2 = new VersionedParcelParcel(parcel, dataPosition, i, sb.append(this.mPrefix).append("  ").toString());
        return versionedParcelParcel;
    }

    public void writeByteArray(byte[] bArr) {
        byte[] b = bArr;
        if (b != null) {
            this.mParcel.writeInt(b.length);
            this.mParcel.writeByteArray(b);
            return;
        }
        this.mParcel.writeInt(-1);
    }

    public void writeByteArray(byte[] bArr, int i, int i2) {
        byte[] b = bArr;
        int offset = i;
        int len = i2;
        if (b != null) {
            this.mParcel.writeInt(b.length);
            this.mParcel.writeByteArray(b, offset, len);
            return;
        }
        this.mParcel.writeInt(-1);
    }

    public void writeInt(int val) {
        this.mParcel.writeInt(val);
    }

    public void writeLong(long val) {
        this.mParcel.writeLong(val);
    }

    public void writeFloat(float val) {
        this.mParcel.writeFloat(val);
    }

    public void writeDouble(double val) {
        this.mParcel.writeDouble(val);
    }

    public void writeString(String val) {
        this.mParcel.writeString(val);
    }

    public void writeStrongBinder(IBinder val) {
        this.mParcel.writeStrongBinder(val);
    }

    public void writeParcelable(Parcelable p) {
        this.mParcel.writeParcelable(p, 0);
    }

    public void writeBoolean(boolean val) {
        this.mParcel.writeInt(val ? 1 : 0);
    }

    public void writeStrongInterface(IInterface val) {
        this.mParcel.writeStrongInterface(val);
    }

    public void writeBundle(Bundle val) {
        this.mParcel.writeBundle(val);
    }

    public int readInt() {
        return this.mParcel.readInt();
    }

    public long readLong() {
        return this.mParcel.readLong();
    }

    public float readFloat() {
        return this.mParcel.readFloat();
    }

    public double readDouble() {
        return this.mParcel.readDouble();
    }

    public String readString() {
        return this.mParcel.readString();
    }

    public IBinder readStrongBinder() {
        return this.mParcel.readStrongBinder();
    }

    public byte[] readByteArray() {
        int len = this.mParcel.readInt();
        if (len < 0) {
            return null;
        }
        byte[] bytes = new byte[len];
        this.mParcel.readByteArray(bytes);
        return bytes;
    }

    public <T extends Parcelable> T readParcelable() {
        return this.mParcel.readParcelable(getClass().getClassLoader());
    }

    public Bundle readBundle() {
        return this.mParcel.readBundle(getClass().getClassLoader());
    }

    public boolean readBoolean() {
        return this.mParcel.readInt() != 0;
    }
}