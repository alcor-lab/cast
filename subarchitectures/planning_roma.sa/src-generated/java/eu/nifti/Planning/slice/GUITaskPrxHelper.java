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
// Generated from file `GUITaskPrxHelper.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package eu.nifti.Planning.slice;

public final class GUITaskPrxHelper extends Ice.ObjectPrxHelperBase implements GUITaskPrx
{
    public static GUITaskPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
        GUITaskPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (GUITaskPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA(ice_staticId()))
                {
                    GUITaskPrxHelper __h = new GUITaskPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static GUITaskPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        GUITaskPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (GUITaskPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA(ice_staticId(), __ctx))
                {
                    GUITaskPrxHelper __h = new GUITaskPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static GUITaskPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        GUITaskPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA(ice_staticId()))
                {
                    GUITaskPrxHelper __h = new GUITaskPrxHelper();
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

    public static GUITaskPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        GUITaskPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA(ice_staticId(), __ctx))
                {
                    GUITaskPrxHelper __h = new GUITaskPrxHelper();
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

    public static GUITaskPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
        GUITaskPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (GUITaskPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                GUITaskPrxHelper __h = new GUITaskPrxHelper();
                __h.__copyFrom(__obj);
                __d = __h;
            }
        }
        return __d;
    }

    public static GUITaskPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        GUITaskPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            GUITaskPrxHelper __h = new GUITaskPrxHelper();
            __h.__copyFrom(__bb);
            __d = __h;
        }
        return __d;
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::eu::nifti::Planning::slice::GUITask",
        "::eu::nifti::Planning::slice::Task"
    };

    public static String
    ice_staticId()
    {
        return __ids[1];
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
        return new _GUITaskDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
        return new _GUITaskDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, GUITaskPrx v)
    {
        __os.writeProxy(v);
    }

    public static GUITaskPrx
    __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            GUITaskPrxHelper result = new GUITaskPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}
