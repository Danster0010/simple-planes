//package xyz.przemyk.simpleplanes.network;
//
//import net.minecraft.server.level.ServerPlayer;
//import net.minecraft.network.FriendlyByteBuf;
//import net.minecraftforge.network.NetworkEvent;
//import xyz.przemyk.simpleplanes.container.PlaneWorkbenchContainer;
//
//import java.util.function.Supplier;
//
//public class CycleItemsPacket {
//
//    private final Type type;
//
//    public CycleItemsPacket(Type type) {
//        this.type = type;
//    }
//
//    public CycleItemsPacket(FriendlyByteBuf buffer) {
//        this.type = Type.values()[buffer.readByte()];
//    }
//
//    public void toBytes(FriendlyByteBuf buffer) {
//        buffer.writeByte(type.ordinal());
//    }
//
//    public void handle(Supplier<NetworkEvent.Context> ctxSup) {
//        NetworkEvent.Context ctx = ctxSup.get();
//        ctx.enqueueWork(() -> {
//            ServerPlayer sender = ctx.getSender();
//            if (sender.containerMenu instanceof PlaneWorkbenchContainer workbenchContainer) {
//                workbenchContainer.cycleItems(type);
//            }
//        });
//        ctx.setPacketHandled(true);
//    }
//
//    public enum Type {
//        CRAFTING_LEFT,
//        CRAFTING_RIGHT
//    }
//}
