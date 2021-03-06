// **********************************************************************
//
// Copyright (c) 2003-2011 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.4.2
//
// <auto-generated>
//
// Generated from file `RobotStatus.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package eu.nifti.env.status;

public class RobotStatus extends Ice.ObjectImpl
{
    public RobotStatus()
    {
    }

    public RobotStatus(double batteryLevel, int batteryStatus, boolean brakeOn, double scanningSpeed, ControllersStatus status, ControllersStatus error)
    {
        this.batteryLevel = batteryLevel;
        this.batteryStatus = batteryStatus;
        this.brakeOn = brakeOn;
        this.scanningSpeed = scanningSpeed;
        this.status = status;
        this.error = error;
    }

    private static class __F implements Ice.ObjectFactory
    {
        public Ice.Object
        create(String type)
        {
            assert(type.equals(ice_staticId()));
            return new RobotStatus();
        }

        public void
        destroy()
        {
        }
    }
    private static Ice.ObjectFactory _factory = new __F();

    public static Ice.ObjectFactory
    ice_factory()
    {
        return _factory;
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::eu::nifti::env::status::RobotStatus"
    };

    public boolean
    ice_isA(String s)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public boolean
    ice_isA(String s, Ice.Current __current)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public String[]
    ice_ids()
    {
        return __ids;
    }

    public String[]
    ice_ids(Ice.Current __current)
    {
        return __ids;
    }

    public String
    ice_id()
    {
        return __ids[1];
    }

    public String
    ice_id(Ice.Current __current)
    {
        return __ids[1];
    }

    public static String
    ice_staticId()
    {
        return __ids[1];
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeTypeId(ice_staticId());
        __os.startWriteSlice();
        __os.writeDouble(batteryLevel);
        __os.writeInt(batteryStatus);
        __os.writeBool(brakeOn);
        __os.writeDouble(scanningSpeed);
        __os.writeObject(status);
        __os.writeObject(error);
        __os.endWriteSlice();
        super.__write(__os);
    }

    private class Patcher implements IceInternal.Patcher
    {
        Patcher(int member)
        {
            __member = member;
        }

        public void
        patch(Ice.Object v)
        {
            try
            {
                switch(__member)
                {
                case 0:
                    __typeId = "::eu::nifti::env::status::ControllersStatus";
                    status = (ControllersStatus)v;
                    break;
                case 1:
                    __typeId = "::eu::nifti::env::status::ControllersStatus";
                    error = (ControllersStatus)v;
                    break;
                }
            }
            catch(ClassCastException ex)
            {
                IceInternal.Ex.throwUOE(type(), v.ice_id());
            }
        }

        public String
        type()
        {
            return __typeId;
        }

        private int __member;
        private String __typeId;
    }

    public void
    __read(IceInternal.BasicStream __is, boolean __rid)
    {
        if(__rid)
        {
            __is.readTypeId();
        }
        __is.startReadSlice();
        batteryLevel = __is.readDouble();
        batteryStatus = __is.readInt();
        brakeOn = __is.readBool();
        scanningSpeed = __is.readDouble();
        __is.readObject(new Patcher(0));
        __is.readObject(new Patcher(1));
        __is.endReadSlice();
        super.__read(__is, true);
    }

    public void
    __write(Ice.OutputStream __outS)
    {
        Ice.MarshalException ex = new Ice.MarshalException();
        ex.reason = "type eu::nifti::env::status::RobotStatus was not generated with stream support";
        throw ex;
    }

    public void
    __read(Ice.InputStream __inS, boolean __rid)
    {
        Ice.MarshalException ex = new Ice.MarshalException();
        ex.reason = "type eu::nifti::env::status::RobotStatus was not generated with stream support";
        throw ex;
    }

    public double batteryLevel;

    public int batteryStatus;

    public boolean brakeOn;

    public double scanningSpeed;

    public ControllersStatus status;

    public ControllersStatus error;
}
