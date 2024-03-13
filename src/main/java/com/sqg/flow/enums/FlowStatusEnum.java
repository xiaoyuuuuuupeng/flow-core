package com.sqg.flow.enums;

public enum FlowStatusEnum {
    INIT("初始化", 0),
    START("启动", 1),
    END("结束", 2),
    READY_TO_START("已准备启动", 3),
    RUNNING("运行中", 4),
    PAUSE("暂停", 5),
    STOP("停止", 6),
    ERROR("错误", 7),
    SUCCESS("成功", 8);;

    private String statusStr;
    private int status;

    FlowStatusEnum(String statusStr, int status) {
        this.statusStr = statusStr;
        this.status = status;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public int getStatus() {
        return status;
    }

    public static FlowStatusEnum getFlowStatusEnum(String statusStr) {
        for (FlowStatusEnum flowStatusEnum : FlowStatusEnum.values()) {
            if (flowStatusEnum.getStatusStr().equals(statusStr)) {
                return flowStatusEnum;
            }
        }
        return null;
    }

    public static FlowStatusEnum getFlowStatusEnum(int status) {
        for (FlowStatusEnum flowStatusEnum : FlowStatusEnum.values()) {
            if (flowStatusEnum.getStatus() == status) {
                return flowStatusEnum;
            }
        }
        return null;
    }
}
