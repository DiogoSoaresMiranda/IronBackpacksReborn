package main.ironbackpacks.network;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import main.ironbackpacks.container.alternateGui.ContainerAlternateGui;

/**
 * Message used when renaming the backpack
 */
public class RenameMessage implements IMessage {

    private String newName;

    public RenameMessage() {}

    public RenameMessage(String newName) {
        this.newName = newName;
    }

    @Override
    public void fromBytes(ByteBuf buf){
        newName = ByteBufUtils.readUTF8String(buf);
    }

    @Override
    public void toBytes(ByteBuf buf){
        ByteBufUtils.writeUTF8String(buf, newName);
    }

    public static class Handler implements IMessageHandler<RenameMessage, IMessage> {

        @Override
        public IMessage onMessage(RenameMessage message, MessageContext ctx) {
            ContainerAlternateGui containerAlternate = (ContainerAlternateGui) ctx.getServerHandler().playerEntity.openContainer;
            containerAlternate.renameBackpack(message.newName);
            return null; //no return message necessary
        }

    }

}


