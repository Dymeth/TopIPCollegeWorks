package me.dymeth.college.winapi;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinDef.DWORD;

public class CreateProcess {

    @SuppressWarnings("ConstantValue")
    static void main(String[] args) {
        String lpApplicationName = null;
        String lpCommandLine = "cmd.exe /k echo Hello from WinAPI";
        WinBase.SECURITY_ATTRIBUTES lpProcessAttributes = null;
        WinBase.SECURITY_ATTRIBUTES lpThreadAttributes = null;
        boolean bInheritHandles = false;
        DWORD dwCreationFlags = new DWORD(0x00000010);
        Pointer lpEnvironment = null;
        String lpCurrentDirectory = null;
        WinBase.STARTUPINFO lpStartupInfo = new WinBase.STARTUPINFO();
        lpStartupInfo.cb = new DWORD(lpStartupInfo.size());
        WinBase.PROCESS_INFORMATION lpProcessInformation = new WinBase.PROCESS_INFORMATION();

        boolean success = Kernel32.INSTANCE.CreateProcess(
                lpApplicationName,
                lpCommandLine,
                lpProcessAttributes,
                lpThreadAttributes,
                bInheritHandles,
                dwCreationFlags,
                lpEnvironment,
                lpCurrentDirectory,
                lpStartupInfo,
                lpProcessInformation
        );

        if (!success) {
            throw new RuntimeException("Unable to start process: " + Native.getLastError());
        }

        System.out.println("Process started, PID = " + lpProcessInformation.dwProcessId.intValue());
    }
}
