package bucketproblem;
/*
 created for bucket object and bucket actions
 */
public class bucket {

    private String name;
    private int size;
    private int vol;

    public void fill() {
        this.setVol(this.getSize());//fill the bucket
    }

    public void dump() {
        this.setVol(0);//dump the bucket
    }

    public void pour(bucket thatBucket) {//pour the bucket within rest capacity of full capacity
        if (this.getVol() > thatBucket.getSize() - thatBucket.getVol()) {
            //source vol greater than target capacity
            this.setVol(this.getVol() - (thatBucket.getSize() - thatBucket.getVol()));
            thatBucket.setVol(thatBucket.size);
        } else {
            thatBucket.setVol(thatBucket.getVol() + this.getVol());
            this.dump();
        }
    }

    public String getName() {
        return name;//return the name
    }

    public void setName(String name) {
        this.name = name;//@param name the name to set
    }

    public int getSize() {
        return size;//@return the size
    }

    public void setSize(int size) {
        this.size = size;//@param size the size to set
    }

    public int getVol() {
        return vol;//@return the vol
    }

    public void setVol(int vol) {
        this.vol = vol;//@param vol the vol to set
    }

}