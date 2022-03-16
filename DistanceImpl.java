package com.replace.replace.api.distance;

import org.springframework.stereotype.Service;

/**
 * @author Romain Lavabre <romainlavabre98@gmail.com>
 */
@Service
public class DistanceImpl implements Distance {

    @Override
    public double getDistance( Double latFrom, Double longFrom, Double latTo, Double longTo, DistanceUnit distanceUnit ) {
        if ( isContainsNull( latFrom, longFrom, latTo, latFrom ) ) {
            return 0;
        }

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
    protected double deg2rad( double deg ) {
        return deg * Math.PI / 180.0;
    }


    /**
     * @param rad radians
     * @return decimal degrees
     */
    protected double rad2deg( double rad ) {
        return rad * 180.0 / Math.PI;
    }


    private boolean isContainsNull( Double... positions ) {
        for ( Double position : positions ) {
            if ( position == null ) {
                return true;
            }
        }

        return false;
    }
}
