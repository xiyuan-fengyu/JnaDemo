package com.xiyuan.jna;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.IntByReference;

/**
 * Created by xiyuan_fengyu on 2017/3/14.
 */
public class Kernel32Test {

    public static void main(String[] args) {
        WinNT.HANDLE handle = Kernel32.INSTANCE.OpenProcess(WinNT.PROCESS_ALL_ACCESS, false, 22408);
        Pointer baseAddress = Pointer.createConstant(0);
        Pointer resultAddress = Pointer.createConstant(0x111111);
        IntByReference readLen = new IntByReference(0);
        Kernel32.INSTANCE.ReadProcessMemory(handle, baseAddress, resultAddress, 64, readLen);
        System.out.println(readLen.getValue());
    }

}