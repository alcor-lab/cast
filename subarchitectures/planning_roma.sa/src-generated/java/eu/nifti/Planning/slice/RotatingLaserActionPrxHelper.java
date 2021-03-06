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
// Generated from file `RotatingLaserActionPrxHelper.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package eu.nifti.Planning.slice;

public final class RotatingLaserActionPrxHelper extends Ice.ObjectPrxHelperBase implements RotatingLaserActionPrx
{
    public static RotatingLaserActionPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
        RotatingLaserActionPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (RotatingLaserActionPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA(ice_staticId()))
                {
                    RotatingLaserActionPrxHelper __h = new RotatingLaserActionPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static RotatingLaserActionPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        RotatingLaserActionPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (RotatingLaserActionPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA(ice_staticId(), __ctx))
                {
                    RotatingLaserActionPrxHelper __h = new RotatingLaserActionPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static RotatingLaserActionPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        RotatingLaserActionPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA(ice_staticId()))
                {
                    RotatingLaserActionPrxHelper __h = new RotatingLaserActionPrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            }
            catch(Ice.FacetNotExistException ex)
            {
            }
        }
        return __d;
    }

    public static RotatingLaserActionPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        RotatingLaserActionPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA(ice_staticId(), __ctx))
                {
                    RotatingLaserActionPrxHelper __h = new RotatingLaserActionPrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            }
            catch(Ice.FacetNotExistException ex)
            {
            }
        }
        return __d;
    }

    public static RotatingLaserActionPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
        RotatingLaserActionPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (RotatingLaserActionPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                RotatingLaserActionPrxHelper __h = new RotatingLaserActionPrxHelper();
                __h.__copyFrom(__obj);
                __d = __h;
            }
        }
        return __d;
    }

    public static RotatingLaserActionPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        RotatingLaserActionPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            RotatingLaserActionPrxHelper __h = new RotatingLaserActionPrxHelper();
            __h.__copyFrom(__bb);
            __d = __h;
        }
        return __d;
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::eu::nifti::Planning::slice::Action",
        "::eu::nifti::Planning::slice::RotatingLaserAction"
    };

    public static String
    ice_staticId()
    {
        return __ids[2];
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
        return new _RotatingLaserActionDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
        return new _RotatingLaserActionDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RotatingLaserActionPrx v)
    {
        __os.writeProxy(v);
    }

    public static RotatingLaserActionPrx
    __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            RotatingLaserActionPrxHelper result = new RotatingLaserActionPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}
