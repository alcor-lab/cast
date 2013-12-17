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
// Generated from file `CenterLaserActionPrxHelper.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package eu.nifti.Planning.slice;

public final class CenterLaserActionPrxHelper extends Ice.ObjectPrxHelperBase implements CenterLaserActionPrx
{
    public static CenterLaserActionPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
        CenterLaserActionPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (CenterLaserActionPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA(ice_staticId()))
                {
                    CenterLaserActionPrxHelper __h = new CenterLaserActionPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static CenterLaserActionPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        CenterLaserActionPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (CenterLaserActionPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA(ice_staticId(), __ctx))
                {
                    CenterLaserActionPrxHelper __h = new CenterLaserActionPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static CenterLaserActionPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        CenterLaserActionPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA(ice_staticId()))
                {
                    CenterLaserActionPrxHelper __h = new CenterLaserActionPrxHelper();
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

    public static CenterLaserActionPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        CenterLaserActionPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA(ice_staticId(), __ctx))
                {
                    CenterLaserActionPrxHelper __h = new CenterLaserActionPrxHelper();
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

    public static CenterLaserActionPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
        CenterLaserActionPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (CenterLaserActionPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                CenterLaserActionPrxHelper __h = new CenterLaserActionPrxHelper();
                __h.__copyFrom(__obj);
                __d = __h;
            }
        }
        return __d;
    }

    public static CenterLaserActionPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        CenterLaserActionPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            CenterLaserActionPrxHelper __h = new CenterLaserActionPrxHelper();
            __h.__copyFrom(__bb);
            __d = __h;
        }
        return __d;
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::eu::nifti::Planning::slice::Action",
        "::eu::nifti::Planning::slice::CenterLaserAction"
    };

    public static String
    ice_staticId()
    {
        return __ids[2];
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
        return new _CenterLaserActionDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
        return new _CenterLaserActionDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, CenterLaserActionPrx v)
    {
        __os.writeProxy(v);
    }

    public static CenterLaserActionPrx
    __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            CenterLaserActionPrxHelper result = new CenterLaserActionPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}
