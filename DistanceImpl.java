package com.replace.replace.api.distance;

import org.springframework.stereotype.Service;

/**
 * @author Romain Lavabre <romainlavabre98@gmail.com>
 */
@Service
public class DistanceImpl implements Distance {

    @Override
    public double getDistance( double latFrom, double longFrom, double latTo, double longTo, DistanceUnit distanceUnit ) {
        double theta = longFrom - longTo;
        double dist  = Math.sin( deg2rad( latFrom ) ) * Math.sin( deg2rad( latTo ) ) + Math.cos( deg2rad( latFrom ) ) * Math.cos( deg2rad( latTo ) ) * Math.cos( deg2rad( theta ) );
        dist = Math.acos( dist );
        dist = rad2deg( dist );
        dist = dist * 60 * 1.1515;

        switch ( distanceUnit ) {
            case MILES:
                return dist;
            case KILOMETER:
                return dist * 1.609344;
            case NAUTICAL_MILES:
                return dist * 0.8684;
        }

        return 0;
    }


    /**
     * @param deg decimal degrees
     * @return radians
     */
    private double deg2rad( double deg ) {
        return deg * Math.PI / 180.0;
    }


    /**
     * @param rad radians
     * @return decimal degrees
     */
    private double rad2deg( double rad ) {
        return rad * 180.0 / Math.PI;
    }
}
