package com.replace.replace.api.distance;

/**
 * @author Romain Lavabre <romainlavabre98@gmail.com>
 */
public interface Distance {
    /**
     * @param latFrom      From latitude
     * @param longFrom     From longitude
     * @param latTo        To latitude
     * @param longTo       To longitude
     * @param distanceUnit Unit
     * @return Distance of 2 position to specified unit
     */
    double getDistance( double latFrom, double longFrom, double latTo, double longTo, DistanceUnit distanceUnit );
}
