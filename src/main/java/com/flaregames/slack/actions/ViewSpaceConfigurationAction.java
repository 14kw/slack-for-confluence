package com.flaregames.slack.actions;

import com.atlassian.confluence.spaces.actions.AbstractSpaceAdminAction;
import com.flaregames.slack.components.ConfigurationManager;
import com.opensymphony.xwork.Action;

public final class ViewSpaceConfigurationAction extends AbstractSpaceAdminAction {
   private static final long          serialVersionUID = 5691912273454934901L;

   private final ConfigurationManager configurationManager;
   private String                     spWebhookUrl;
   private String                     channels;
   private boolean                    successFullUpdate;

   public ViewSpaceConfigurationAction(ConfigurationManager configurationManager) {
      this.configurationManager = configurationManager;
   }

   public void setResult(String result) {
      if ("success".equals(result)) {
         successFullUpdate = true;
      }
   }

   @Override
   public String execute() {
      setSpWebhookUrl(configurationManager.getSpaceWebhookUrl(key));
      setChannels(configurationManager.getSpaceChannels(key));
      return Action.SUCCESS;
   }

   public void setSpWebhookUrl(String spWebhookUrl) {
      this.spWebhookUrl = spWebhookUrl;
   }

   public String getSpWebhookUrl() {
      return spWebhookUrl;
   }

   public void setChannels(String channels) {
      this.channels = channels;
   }

   public String getChannels() {
      return channels;
   }

   public boolean isSuccessFullUpdate() {
      return successFullUpdate;
   }
}
