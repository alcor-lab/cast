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
// Generated from file `State.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package eu.nifti.Planning.slice;

public enum State implements java.io.Serializable
{
    
    COMPLETED,
    
    FAILED,
    
    PENDING,
    
    CONFIRMED,
    
    ABORTED,
    
    ADDED,
    
    DELETED,
    
    EXECUTED,
    
    REQUESTED,
    
    NEW,
    
    EXECUTING,
    
    REJECTED;

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeByte((byte)ordinal());
    }

    public static State
    __read(IceInternal.BasicStream __is)
    {
        int __v = __is.readByte(12);
        return values()[__v];
    }
}